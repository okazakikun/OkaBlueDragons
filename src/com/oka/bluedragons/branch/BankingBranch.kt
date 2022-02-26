package com.oka.bluedragons.branch

import com.oka.bluedragons.Constants.AREA_FALLY
import com.oka.bluedragons.Script
import com.oka.bluedragons.leaf.OpenBank
import com.oka.bluedragons.leaf.TeleToFally
import org.powbot.api.rt4.Players
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent

class InFally(script: Script) : Branch<Script>(script, "Bank open") {
    override val successComponent: TreeComponent<Script> = OpenBank(script)
    override val failedComponent: TreeComponent<Script> = TeleToFally(script)

    override fun validate(): Boolean {
        return AREA_FALLY.contains(Players.local().tile())
    }
}
