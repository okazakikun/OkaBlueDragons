package com.oka.bluedragons.branch

import com.oka.bluedragons.Constants.ID_LOOT
import com.oka.bluedragons.Script
import com.oka.bluedragons.leaf.bankopened.CloseBank
import com.oka.bluedragons.leaf.bankopened.DepositLoot
import org.powbot.api.rt4.Inventory
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent

class HaveLoot(script: Script) : Branch<Script>(script, "Have loot") {
    override val successComponent: TreeComponent<Script> = DepositLoot(script)
    override val failedComponent: TreeComponent<Script> = CloseBank(script)

    override fun validate(): Boolean {
        return Inventory.stream().id(*ID_LOOT).isNotEmpty()
    }
}
