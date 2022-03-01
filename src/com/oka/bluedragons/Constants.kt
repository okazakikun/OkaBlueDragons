package com.oka.bluedragons

import org.powbot.api.Area
import org.powbot.api.Tile


object Constants {
    val ID_LOOT = intArrayOf(536, 1751, 561) //Dragon bones, Blue Dragon Hide, Nature runes
    val ID_ITEMSTOKEEP = intArrayOf(563, 556, 555, 23650, 12791, 24416) //tele runes + rune pouch
    val ID_DRAGON = 265

    val TILE_SAFESPOT = Tile(2900, 9809, 0)

    val AREA_FALLY = Area(Tile(2936, 3392, 0), Tile(2986, 3357, 0))
    val AREA_DUNGEON = Area(Tile(2891, 9816, 0), Tile(2921, 9786, 0))
    val AREA_DRAGON_SPAWN = Area(Tile(2896, 9811, 0), Tile(2905, 9801, 0))
    val AREA_LOOT = Area(Tile(2896, 9807, 0), Tile(2902, 9801, 0))
    var AREA_DRAGON: Area? = null
}