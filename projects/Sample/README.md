# **Sample Minecraft Plugin**
Nachrichten des Plugins im Chat sind durch das Präfix `[Sample]` gekennzeichnet.

# Stats
- Minecraft Version: `1.21.8`  
- Java Version: `jdk 21`
- Template: `Paper`
- Build System: `Gradle`
- Group Id: `com.nik`
- Artifact Id: `sample`
- Main class: `com.nik.sample.Main`

# File Structure
```
Sample
├─ build.gradle
├─ gradle/wrapper
│  └─ gradle-wrapper.properties
├─ gradle.properties
├─ gradlew
├─ gradlew.bat
├─ README.md
├─ settings.gradle
└─ src/main
   ├─ java/com/nik/sample
   │  ├─ commands
   │  │  ├─ hat
   │  │  │  └─ HatCommand.java
   │  │  └─ InvCommand.java
   │  ├─ config
   │  │  └─ Config.java
   │  ├─ lockchest
   │  │  ├─ commands
   │  │  │  ├─ LockCommand.java
   │  │  │  ├─ SaveConfigCommand.java
   │  │  │  └─ UnlockCommand.java
   │  │  ├─ listener
   │  │  │  ├─ BreakBlockListener.java
   │  │  │  ├─ EntityExplodeEvent.java
   │  │  │  └─ OpenChestListener.java
   │  │  ├─ Lockchest.java
   │  │  └─ LockChestManager.java
   │  ├─ Main.java
   │  └─ utils
   │     └─ HashUtils.java
   └─ resources
      └─ plugin.yml
```

# Features

## Spieler Inventar ansehen
Ein Spieler Inventar in einer Chest GUI ansehen

### Commands
| Command                      | Beschreibung                                          |
|----------------------------- |------------------------------------------------------ |
| <kbd>/inv [Playername]</kbd> | Spieler Inventar des spezifizierten Spielers ansehen. |


## Hat
Setze per command das Item, welches du aktuell in der Hand trägst als Helm

### Commands
| Command         | Beschreibung                                  |
|---------------- |-----------------------------------------------|
| <kbd>/hat</kbd> | Setzt das aktuelle Item in der Hand als Helm. |


## Lockchest
Kisten sperren per command.

### Commands
| Command                       | Beschreibung                                                         |
|------------------------------ |--------------------------------------------------------------------- |
| <kbd>/lock [password]</kbd>   | Kiste auf die man beim ausführen des commands schaut, wird mit dem gesetzten Passwort gelockt.  |
| <kbd>/unlock [password]</kbd> | Kiste auf die man beim ausführen des commands schaut, wird mit dem gesetzten Passwort unlocked. |

### Extras
- Beim Rechtsklick auf eine Verschlossene Kiste, wird das Passwort im Chat abgefragt!
- Versperrte Kisten können nicht abgebaut oder zerstört werden
- Passwörter werden als Hash gespeichert. Kein Salt!
- Verschlossene Kisten werden in einer Config Datei unter `[Server Directory]/plugins/Sample/config.yaml` gespeichert.


# Showcase
## Spieler Inventar ansehen
<img src="./../../gifs/sample_plugin/inv-command-showcase.gif">


## Hat
<img src="./../../gifs/sample_plugin/hat-command-showcase.gif">

## Lockchest
<img src="./../../gifs/sample_plugin/lockchest-showcase.gif">

