# Mob AI

Smalltalk with Mobs

**Important:** This plugin is just a CLIENT. All questions are handled by our REST API (server side). <br>
It is based on NullDev's AIKIN AI. See here: <br>
https://github.com/NLDev/Telegram-AI

That means you will need your own endpoint to use this plugin. 

## What does it do? 

It enables you to speak to mobs. By simply entering 

`/mob YOUR TEXT`

All mobs in a specific range will reply to you!

Default Config:  

```YAML

 ################
 #--------------#
 # MobAI Config #
 #--------------#
 ################

# Should only one mob (the nearest) be targeted?
OnlyNearestMob: false

# The distance (in blocks) of how many mobs should respond
BlockDistance: 100

# Should the color of the response message on the head of the mob be random? 
RandomResponseColor: true 

# WHat color to use for the mob response message
# Note: This option is only use if 'RandomResponseColor' above is set to false!
# Also: For a list of supported colors check here:
# https://wiki.ess3.net/mc/
ResponseColor: "&f"
```
