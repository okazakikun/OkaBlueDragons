package com.oka.bluedragons.leaf.bankopened

import com.oka.bluedragons.Constants.ID_ITEMSTOKEEP
import com.oka.bluedragons.Script
import org.powbot.api.rt4.Bank
import org.powbot.api.script.tree.Leaf


class DepositLoot(script: Script) : Leaf<Script>(script, "Depositing loot") {
    override fun execute() {
        Bank.depositAllExcept(*ID_ITEMSTOKEEP)
    }
}
