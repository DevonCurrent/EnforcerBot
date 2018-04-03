# Admin Bot - Discord

##### Developed by: Devon Current, Ryan Denney, Sean Jones, Jawad al-Mamoon

Admin Bot is created in Java with the [JDA library](https://github.com/DV8FromTheWorld/JDA). This bot solves the issue of finding a more efficient way for administrators on Discord to perform their responsibilities on the members of the server. This involves both having a good time in the server, as well as admin priviledges (kicking, banning, enforcing rules, etc.)

### Features Include
- Requesting help if needed for commands
- Kicking and banning members from a server
- Unbanning members from a server
- Create x number of voice channels

### Future Features
- Private greeting messages
- Random number generator for people that want to play D&D or other related games
- Tic-Tac-Toe
- **Go live**

### Commands
```
!help
!ban [@user]
!kick [@user]
!unban [user]
!channels [number]
```
### Completed User Stories
- As a user, I want to ask for help if I do not know how functions on the bot work.
- As an admin, I want to be able to kick users that I want removed from the server, but are not placed on a ban list.
- As an admin, I want to ban users that I want removed from the server and placed on a ban list so they cannot rejoin.
- As an admin, I want to unban users that were previously banned and placed on the ban list.
- As an admin, I want to create x number of voice channels so that I can quickly create more than one channel.

### Iteration 3 User Stories
- As an admin, I want to have the bot send private message to new members that join the server, to introduce them to the server.
- As an admin, I want to be able to stop users from spamming obnoxious messages to channels (spam and possibly swearing).
- As a user, I want to be able to have a random number generator so I can play D&D, or otherwise make up a number for a game.
- As a member of the server, I want to be able to play tic-tac-toe with other users in the server.

### Acceptance Testing Results
###### Iteration 1:
Testing was performed on online users on a Discord server. Admin users tested the features of our bot and provided feedback on where to go from here:
- I want to be able to kick, ban, unban, and invite users to my Discord server.
- The ping message should be removed and replaced with a real message for users.
- Admin Bot is a poor name for the bot, and there is no avatar picture to go with it.

###### Iteration 2:
Testing was performed on online users and friends that have Discord servers. All users were of the target audience (administrators of Discord servers). The feedback was generally positive, as well as contained the following feedback:
- The bot should take care of swearing in Discord chat and be capable of monitoring the chat.
- The bot should have a unique, fun name and avatar.
- The bot should include games to be able to play with other users.


