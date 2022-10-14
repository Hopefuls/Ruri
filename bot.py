import discord
import os
import config as Config
intents = discord.Intents.all()
bot = discord.Bot(intents=intents)

def setup_cogs():
    for cog in os.listdir("./cogs"):
       if cog.endswith(".py"):
           try:
               bot.load_extension(f"cogs.{cog[:-3]}")
               print(f"[Cogs] Loaded {cog}")
           except Exception as e:
               print(f"[Cogs] Failed to load {cog}")
               print(f"       {e}")

@bot.event
async def on_ready():
    print("[Ruri successfully logged in]")
    print("Name: " + bot.user.name)


setup_cogs()

bot.run(Config.TOKEN)