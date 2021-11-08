# CS611-Legends

Name
-------------------------------------------------------------------------------------------------
--Insert Name--
Yan Tong
--BUID--
U31059912


Files
-------------------------------------------------------------------------------------------------
<.java file> - <1 line comment about the file 
Armor.java: class of armor
ArmorFactory.java: use factory pattern to create armor object
Attackable.java: attackable interface, which means can attack during a fight
Buyable.java: can buy things
Cell.java: cell on grid
CommonCell.java: common cell, can pass or meet monsters
Controller.java: class to control logic flow
Dragon.java: class of dragon
Equipable.java: interface of equipable things, can equip on role.
Exoskeleton.java: class of exoskeleton
Fight.java: class of fight
FireSpell.java: class of fire spell
Game.java: class of game
Grid.java: class of grid
Hero.java: class of hero
HeroFactory.java: use factory pattern to create hero object
IceSpell.java: class of ice spell
InaccessibleCell.java: class of inaccessible cell on grid
Inventory.java: class of inventory of a role
Item.java: class of item
ItemFactory.java: use factory pattern to create item
LightningSpell.java: class of lightning spell
Main.java: main class
MarketCell.java: class of market cell on grid
Monster.java: abstract class of monster
MonsterAndHeroGame.java: class of MAH game
MonsterFactory.java: use factory pattern to create monsters
Paladin.java: class of paladin
Potion.java: class of potion
PotionFactory.java: use factory pattern to create potion
RPGGame.java: class of RPG game
ReadFileUtil.java: util class to read config files
Role.java: abstract class of role
RoleFactory.java: use factory pattern to create role
ScanUtil.java: util class to read user input
Sellable.java: interface of sellable items
Sorcerer.java: class of sorcerer
Spell.java: abstract class of spell
SpellFactory.java: use factory pattern to create spell
Spirit.java: class of spirit
Stats.java: class of stats
Team.java: class of team
TeamIterable.java: interface of iterable team. use Iterator pattern on Team.
TeamIterator.java: interface of team iterator. use Iterator pattern on Team.
Warrior.java: class of warrior
Weapon.java: class of weapon
WeaponFactory.java: use factory pattern to create weapon


Notes:
-------------------------------------------------------------------------------------------------
Design pattern:
1. Factory Pattern: When getting new object of Armor, Hero, Monster, Spell, Weapon, Potion, I use Factory pattern to create.
2. Singleton Pattern: Each factory is a singleton.
3. Iterator Pattern: When iterate over a team, I use Iterator pattern, which can let me iterate all alive team member and iterate all team member (regardless of hp).

Coding platform:
MacOS


How to run:
-------------------------------------------------------------------------------------------------
1. Navigate to the directory after downloading the project
2. Run the following instructions on command line:
	javac *.java
	java Main
