Digital Dungeon Access Protocol (DDAP)

| Client Request | Server Response                   | Description                    |
|----------------|-----------------------------------|--------------------------------|
| STAMINA        | given stamina                     | Get the stamina of character   |
| ATTACK         | boss' new health and damage dealt | Attack the boss of the dungeon |
| HEALTH         | boss' current health              | Boss current health            |
| DESC           | description of boss               | Gives a description of boss    |
| QUIT           | Quit the connection               |                                |

Protocol change: Stamina no longer serves "character c". A given client is treated as the character.