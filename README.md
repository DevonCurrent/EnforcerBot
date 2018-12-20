# EnforcerBot - Discord

##### Developed by: Devon Current, Ryan Denney, Sean Jones, Jawad al-Mamoon

Admin Bot is created in Java with the [JDA library](https://github.com/DV8FromTheWorld/JDA). This bot solves the issue of finding a more efficient way for administrators on Discord to perform their responsibilities on the members of the server. This involves both having a good time in the server, as well as admin priviledges (kicking, banning, enforcing rules, etc.)

### Features Include
- Ban members that are unwanted from your server, and prevent them from joining back.
- Create 1-10 voice channels for your members to be a part of.
- Send a greeting message to new members that join your server.
- Kick members that you want removed from your server, but they can join back with an invite.
- Random number generator for your members.
- Unban members from your server's ban list. You still need to invite them back though!
- Spam monitor that will kick members that create spam in your server (3 of the same messages in a row).

### Commands
```
"!ban [@User] - I will ban the user from the server and places them on the ban list.
!channels [1-10] - I will create one to ten voice channels.
!greetings [string] - set up a message and I will DM any new members that join your server.
!greetings? - I'll remind you what you set your greetings message as for new members.
!help - I will send a message to the channel explaining what my commands are.
!kick [@User] - I will kick the user from the server. They can rejoin if they have an invite though.
!ping - Relay bot latency.
!rng [n] - I will choose a random number from 1 to n. If you don't give me a value, I will choose 6.
!Unban [User] - I will remove that user from the server ban list. This will NOT invite them back though.
```
### Completed User Stories
- As a user, I want to ask for help if I do not know how functions on the bot work.
- As an admin, I want to be able to kick users that I want removed from the server, but are not placed on a ban list.
- As an admin, I want to ban users that I want removed from the server and placed on a ban list so they cannot rejoin.
- As an admin, I want to unban users that were previously banned and placed on the ban list.
- As an admin, I want to create x number of voice channels so that I can quickly create more than one channel.
- As an admin, I want to have the bot send private message to new members that join the server, to introduce them to the server.
- As an admin, I want to know what I set the greeting message to for new members that join my server.
- As an admin, I want to be able to stop users from spamming obnoxious messages to channels (3 of the same messages in a row).
- As a user, I want to be able to have a random number generator so I can play D&D, or otherwise make up a number for a game.

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

###### Iteration 3:
Testing was performed on the same target users as from iteration 2's acceptance testing. The feedback provided was:
- Monitoring for the spam works well (and as intended in testing).
- The functions work as intended (not abused by admins).
- The channels function is not incredibly useful, but "is nice to have."
- "You should add more games to the bot."



