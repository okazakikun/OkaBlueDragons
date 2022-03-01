package com.oka.bluedragons.leaf

import com.oka.bluedragons.Constants.ID_DRAGON
import com.oka.bluedragons.Script
import org.powbot.api.Condition
import org.powbot.api.rt4.*
import org.powbot.api.script.tree.Leaf

class AttackDragon(script: Script) : Leaf<Script>(script, "Attacking Dragon") {
    override fun execute() {
        val NPC_DRAGON = Npcs.stream().id(ID_DRAGON).nearest().first()
        if (NPC_DRAGON.inViewport()) {
            if (NPC_DRAGON.interact("attack")) {
                Condition.wait { Players.local().interacting() != NPC_DRAGON }
            }
        }else Camera.turnTo(NPC_DRAGON)
    }
}