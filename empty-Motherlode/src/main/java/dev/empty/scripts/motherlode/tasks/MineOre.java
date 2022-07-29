package dev.empty.scripts.motherlode.tasks;

import net.runelite.api.DialogOption;
import net.runelite.api.NPC;
import net.unethicalite.api.entities.NPCs;
import net.unethicalite.api.movement.Movement;
import net.unethicalite.api.movement.Reachable;
import net.unethicalite.api.widgets.Dialog;

public class MineOre implements ScriptTask
{
	@Override
	public boolean validate()
	{
		return false;
	}

	@Override
	public int execute()
	{
		if (Movement.isWalking())
		{
			return 1000;
		}

		NPC karim = NPCs.getNearest("Karim");
		if (karim == null)
		{
			Movement.walkTo(3274, 3181, 0);
			return 1000;
		}

		if (!Reachable.isInteractable(karim))
		{
			Movement.walkTo(karim);
			return 1000;
		}

		Dialog.invokeDialog(
				DialogOption.NPC_CONTINUE,
				DialogOption.CHAT_OPTION_TWO,
				DialogOption.PLAYER_CONTINUE
		);

		karim.interact("Talk-to");
		return 300;
	}
}
