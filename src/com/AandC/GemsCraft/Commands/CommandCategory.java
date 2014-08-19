package com.AandC.GemsCraft.Commands;

public class CommandCategory
{
	/// <summary> Default command category. Do not use it. </summary>
	int None = 0;

	/// <summary> Building-related commands: drawing, binding, copy/paste. </summary>
	int Building = 1;

	/// <summary> Chat-related commands: messaging, ignoring, muting, etc. </summary>
	int Chat = 2;

	/// <summary> Information commands: server, world, zone, rank, and player infos. </summary>
	int Info = 4;

	/// <summary> Moderation commands: kick, ban, rank, tp/bring, etc. </summary>
	int Moderation = 8;

	/// <summary> Server maintenance commands: reloading configs, editing PlayerDB, importing data, etc. </summary>
	int Maintenance = 16;

	/// <summary> World-related commands: joining, loading, renaming, etc. </summary>
	int World = 32;

	/// <summary> Zone-related commands: creating, editing, testing, etc. </summary>
	int Zone = 64;

	/// <summary> Commands that are only used for diagnostics and debugging. </summary>
	int Debug = 128;
}
