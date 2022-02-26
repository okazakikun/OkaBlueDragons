package com.oka.bluedragons.branch

import com.oka.bluedragons.Script
import org.powbot.api.rt4.Bank
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent

/**
 *  The root node which is executed by the script
 */
class IsBankOpened(script: Script) : Branch<Script>(script, "Bank open") {
    override val successComponent: TreeComponent<Script> = HaveLoot(script)
    override val failedComponent: TreeComponent<Script> = FullInv(script)

    override fun validate(): Boolean {
        return Bank.opened()
    }
}
