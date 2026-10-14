package com.example.lab_06

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class WizardTest {

    private lateinit var evilWizard: Wizard
    @Before
    fun setUp() {
        evilWizard = Wizard("Evil Wizard", 30, 10)
    }

    // @Test marks a function as a test.
    // This one checks that casting Explosion with enough mana works.
    @Test
    fun castSpell_explosion_successful() {
        val damageDealt = evilWizard.castSpell("Explosion")

        // assertEquals(expected, actual) fails the test if the two don't match
        assertEquals(30, damageDealt) // spellPower of 10 * 3 = 30

        assertEquals(20, evilWizard.mana) // mana of 30 - 10 = 20
    }

    // This one checks that Explosion fails when there isn't enough mana.
    @Test
    fun castSpell_explosion_unsuccessful() {
        evilWizard.mana = 5 // not enough mana to cast Explosion
        val damageDealt = evilWizard.castSpell("Explosion")

        assertEquals(0, damageDealt) // no damage

        assertEquals(5, evilWizard.mana) // mana is still 5
    }
    // Checks that casting Frostbite with enough mana works.
    @Test
    fun castSpell_frostbite_successful() {
        val damageDealt = evilWizard.castSpell("Frostbite")

        assertEquals(20, damageDealt) // spellPower of 10 * 2 = 20

        assertEquals(25, evilWizard.mana) // mana of 30 - 5 = 25
    }

    // Checks that Frostbite fails when there isn't enough mana.
    @Test
    fun castSpell_frostbite_unsuccessful() {
        evilWizard.mana = 3 // not enough mana to cast Frostbite (it costs 5)
        val damageDealt = evilWizard.castSpell("Frostbite")

        assertEquals(0, damageDealt) // no damage

        assertEquals(3, evilWizard.mana) // mana is still 3
    }
}
