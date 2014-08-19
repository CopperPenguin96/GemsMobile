package com.AandC.GemsCraft.Commands;
import com.AandC.GemsCraft.Exceptions.*;
import com.AandC.GemsCraft.*;
import com.AandC.GemsCraft.PlayerDB.*;

public final class CommandReader
{
	
	
	//Command Offset
	private int Offset;
	public int getOffset() {
		return Offset;
	}
	public void setOffset(int off) {
		Offset = off;
	}
	
	public String RawMessage;
	
	//Command Name
	private String Name;
	public String getName() {
		return Name;
	}
	public void setString(String name) {
		Name = name;
	}
	
	//Confirmed Command
	private boolean isConfirmed;
	public boolean getConfirmed() {
		return isConfirmed;
	}
	public void setConfirmed(boolean conf) {
		isConfirmed = conf;
	}
	//Creates a Copy of an existing command
	public CommandReader(CommandReader other ) throws ArguementNullException{ 
		if( other == null ) throw new ArguementNullException( "other" );
		Offset = other.Offset;
		RawMessage = other.RawMessage;
		Name = other.Name;
		isConfirmed = other.isConfirmed;
	}
	
	//Creates command from raw
	public CommandReader( String rawMessage ) throws ArguementNullException, ArgumentException{
		if( rawMessage == null ) throw new ArguementNullException( "rawMessage" );
		Offset = 1;
		RawMessage = rawMessage;
		String name = Next();
		if( name == null ) {
			throw new ArgumentException( "Raw message must contain the command name.");
		}
		Name = name.toLowerCase();
	}
	//Creates a copy
	public Object Clone() throws ArguementNullException {
		return new CommandReader( this );
	}
	//Grabs next argument of command
	public String Next() {
		for( ; Offset < RawMessage.length(); Offset++ ) {
			int t, j;
			if( RawMessage.charAt(Offset) == '"' ) {
				j = Offset + 1;
				for( ; j < RawMessage.length() && RawMessage.charAt(j) != '"'; j++ ) {}
				t = Offset;
				Offset = j;
				return RawMessage.substring( t + 1, Offset - t - 1 );
			} else if( RawMessage.charAt(Offset) != ' ' ) {
				j = Offset;
				for( ; j < RawMessage.length() && RawMessage.charAt(j) != ' '; j++ ) {}
				t = Offset;
				Offset = j;
				return RawMessage.substring( t, Offset - t );
			}
		}
		return null;
	}
	
	public boolean HasNext() {
		return Offset < RawMessage.length();
	}
	
	public boolean NextInt(int number ) {
		String nextVal = Next();
		if( nextVal == null ) {
			number = 0;
			return false;
		} else {
			boolean didWork;
			try {
				Integer.parseInt(nextVal, number );
			} catch (Exception ex) {
				didWork = false;
			} finally {
				didWork = true;
			}
			return didWork;
		}
	}
	
	public boolean HasInt() {
		if( HasNext() ) {
			int startOffset = Offset;
			String nextVal = Next();
			if( nextVal != null ) {
				int number = 0;
				if( Int32.TryParse( nextVal, number ) ) {
					Offset = startOffset;
					return true;
				}
			}
			Offset = startOffset;
			return false;
			} else {
				return false;
			}
	}
	public String NextAll() {
		for( ; Offset < RawMessage.length(); Offset++ ) {
			if( RawMessage.charAt(Offset) != ' ' ) return RawMessage.substring( Offset );
		}
		return "";
	}
	//DO NOT MODIFY
	public int CountRemaining() {
		int startOffset = Offset;
		int i = 0;
		while( Next() != null ) {
			i++;
		}
		Offset = startOffset;
		return i;
	}
	public int Count() {
		int startOffset = Offset;
		Rewind();
		int i = 1;
		while( Next() != null ) {
			i++;
		}
		Offset = startOffset;
		return i;
	}
	//Allows for arguments to be read again
	public void Rewind() {
		Offset = 1;
		Next();
	}
	public boolean NextBlock(Player player, boolean allowNoneBlock, Block block ) {
		String blockName = Next();
		block = Block.None;
		if( blockName != null ) {
			if( Map.GetBlockByName( blockName, true, block ) ) {
				if( block != Block.None || allowNoneBlock ) {
					return true;
				} else if( player != null ) {
					player.Message( "The \"none\" block is not allowed here" );
				}
			} else if( player != null ) {
				player.Message( "Unrecognized block type \"{0}\"", blockName );
			}
		}
		return false;
	}
	public boolean NextBlockWithParam(Player player, boolean allowNoneBlock, Block block,int param ) {
		block = Block.None;
		param = 1;

		String jointString = Next();
		if( jointString == null ) {
			return false;
		}
		
		int slashIndex = jointString.indexOf( '/' );
		if( slashIndex != -1 ) {
			String blockName = jointString.substring( 0, slashIndex );
			String paramString = jointString.substring( slashIndex + 1 );

			if( Map.GetBlockByName( blockName, true, block ) ) {
				if( block == Block.None && !allowNoneBlock ) {
					if( player != null ) {
						player.Message( "The \"none\" block is not allowed here" );
					}
				} else if( Int32.TryParse( paramString, param ) ) {
					return true;
				} else if( player != null ) {
					player.Message( "Could not parse \"{0}\" as an integer.", paramString );
				}
			} else if( player != null ) {
				player.Message( "Unrecognized block type \"{0}\"", blockName );
			}
		} else {
			if( Map.GetBlockByName( jointString, true, block ) ) {
				if( block != Block.None || allowNoneBlock ) {
					return true;
				} else if( player != null ) {
					player.Message( "The \"none\" block is not allowed here" );
				}
			} else if( player != null ) {
				player.Message( "Unrecognized block type \"{0}\"", jointString );
			}
		}
		return false;
	}

	/// <summary> Reads a token and gets an "on" (1) or "off" (0) input from command. </summary>
	/// <param name="param"> if user gave "on" or "1", this is set to true.
	/// Otherwise (if "off" or "0" is given, if nothing was given,
	/// or if an unrecognized string was given) this is set to false. </param>
	/// <returns> true if a valid string ("on"/"1" or "off"/"0") was given;
	/// false if nothing or an unrecognized string was given. </returns>
	public boolean NextOnOff( boolean param ) {
		String token = Next();
		if( token == null ) {
			// nothing given
			param = false;
			return false;
		} else if( token.equals( "on" ) || token == "1" ) {
			// "on" or "1" given
			param = true;
		} else if( token.equals( "off" ) || token == "0" ) {
			// "off" or "0" given
			param = false;
		} else {
			// unrecognized string given
			param = false;
		}
		return true;
	}
	public String toString() {
		if( isConfirmed ) {
			return String.format( "Command(\"{0}\",{1},confirmed)", RawMessage, Offset );
		} else {
			return String.format( "Command(\"{0}\",{1})", RawMessage, Offset );
		}
	}
}
