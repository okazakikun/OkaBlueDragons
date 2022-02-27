package com.oka.bluedragons.leaf

import com.oka.bluedragons.Constants.ID_DRAGON
import com.oka.bluedragons.Script
import org.powbot.api.Condition
import org.powbot.api.rt4.Npcs
import org.powbot.api.rt4.Players
import org.powbot.api.script.tree.Leaf

class AttackDragon(script: Script) : Leaf<Script>(script, "Attacking Dragon") {
    override fun execute() {
        val dragon = Npcs.stream().id(ID_DRAGON).nearest().first()
        if (dragon.interact("attack")) {
            Condition.wait { Players.local().interacting() != dragon }
        }
    }
}