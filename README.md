<img src="./gifs/Tag_3.gif">
<!-- <img src="./gifs/Tag_5.gif"> -->
<!-- <img src="./gifs/Tag_5.gif"> -->
<!-- <img src="./gifs/Tag_5.gif"> -->

# Setup Guide

<!-- Structure -->
### Structure
1. [Software herunterladen 💾](#software-herunterladen-)
    1. [Download Minecraft](#download-minecraft-) <img src="https://static.wikia.nocookie.net/minecraft_gamepedia/images/1/12/Grass_Block_JE2.png/revision/latest?cb=20200830142618" width="25px" align="center"/>

    2. [Download Java](#download-java-) <img src="https://cdn.freebiesupply.com/logos/large/2x/java-14-logo-png-transparent.png" width="25px" height="30px" align="center"/>

    3. [Download IntelliJ](#download-intellij-) <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/IntelliJ_IDEA_Icon.svg/768px-IntelliJ_IDEA_Icon.svg.png?20200803071016g" width="25px" align="center"/>

    4. [Download Paper](#download-paper-) <img src="https://cdn.worldvectorlogo.com/logos/papermc.svg" width="25px" align="center"/>

2. [Paper Server einrichten](#paper-server-einrichten-) <img src="https://cdn.worldvectorlogo.com/logos/papermc.svg" width="25px" align="center"/>

3. [IntelliJ einrichten](#intellij-einrichten-) <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/IntelliJ_IDEA_Icon.svg/768px-IntelliJ_IDEA_Icon.svg.png?20200803071016g" width="25px" align="center"/>

4. [Erstellen eines ersten Plugins 🛠️](#erstellen-eines-ersten-plugins)

5. [Zusatz ➕](#zusatz-)
    1. [Output Ordner der Build Datei festlegen 📂](#output-ordner-der-build-datei-festlegen-)

6. [Projects 🚀](#projects-)
    1. [Sample 🧪](#sample-)

7. [Contributors ✨](#contributors-)

<br>
<br>

# Software herunterladen 💾

<!-- ↓ Download Minecraft ↓ -->

## Download Minecraft <img src="https://static.wikia.nocookie.net/minecraft_gamepedia/images/1/12/Grass_Block_JE2.png/revision/latest?cb=20200830142618" width="40px" align="center"/>

Minecraft ist das Computerspiel für welches wir Plugins erstellen wollen.

### Website
&nbsp;&nbsp;&nbsp;&nbsp;[Minecraft Download Page](https://www.minecraft.net/de-de/download)

<!-- Back to top Button -->
<p align="center"><a href="#setup-guide"><kbd>🔼 Back to top</kbd></a></p>

<!-- ↑ Download Minecraft ↑ -->


<!-- ↓ Download Java ↓ -->

## Download Java <img src="https://cdn.freebiesupply.com/logos/large/2x/java-14-logo-png-transparent.png" width="40px" height="50px" align="center"/>

Java ist die absolute Basis, in dieser Objektorientierten Programmiersprache schreiben wir unsere Plugins.

### Benötigte Java-Version
- Version: `JDK 21`
- Betriebssystem: `Windows`

### Website
&nbsp;&nbsp;&nbsp;&nbsp;[Java JDK 21 Download Page](https://www.oracle.com/java/technologies/downloads/#jdk21-windows)

<!-- Doppel Leerzeichen macht neue Zeile -->
> **Note:**  
> Java JDK 21 wird benötigt um Plugins für die neueste Minecraft Version zu
> erstellen. Sie enthält direkt das entsprechende JRE, weshalb man das
> Runtime Environment nicht extra herunterladen muss.

<!-- Back to top Button -->
<p align="center"><a href="#setup-guide"><kbd>🔼 Back to top</kbd></a></p>

<!-- ↑ Download Java ↑ -->


<!-- ↓ Download IntelliJ ↓ -->

## Download IntelliJ <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/IntelliJ_IDEA_Icon.svg/768px-IntelliJ_IDEA_Icon.svg.png?20200803071016g" width="40px" align="center"/>

IntelliJ ist die IDE mit der wir unsere Plugins in der Programmiersprache Java erstellen wollen.

### Website
&nbsp;&nbsp;&nbsp;&nbsp;[IntelliJ Download Page](https://www.jetbrains.com/idea/download/?section=windows)

> ⚠️ **Wichtig:**  
> Auf der Seite herunterscrollen und Community Edition herunterladen.

<!-- Back to top Button -->
<p align="center"><a href="#setup-guide"><kbd>🔼 Back to top</kbd></a></p>

<!-- ↑ Download IntelliJ ↑ -->


<!-- ↓ Download Paper ↓ -->

## Download Paper <img src="https://cdn.worldvectorlogo.com/logos/papermc.svg" width="40px" align="center"/>

### Vorher
&nbsp;&nbsp;&nbsp;&nbsp;Ordner erstellen in dem die heruntergeladene Server Datei abgelegt werden kann.  
&nbsp;&nbsp;&nbsp;&nbsp;Zum Beispiel:  
&nbsp;&nbsp;&nbsp;&nbsp;`C:\Users\Max\1.21.8 - Server`

### Benötigte Paper-Version
- Version: `1.21.8`
- Build: `Newest Build`

### Website
&nbsp;&nbsp;&nbsp;&nbsp;[Paper Download Page](https://papermc.io/downloads/paper)

<!-- Back to top Button -->
<p align="center"><a href="#setup-guide"><kbd>🔼 Back to top</kbd></a></p>

<!-- ↑ Download Paper ↑ -->

<br>
<br>

<!-- ↓ Paper Server einrichten ↓ -->

# Paper Server einrichten <img src="https://cdn.worldvectorlogo.com/logos/papermc.svg" width="40px" align="center"/>

### Prüfen ob Java installiert ist
  - Command (in CMD ausführen):  
    `java -version`  
    Wenn es keinen Fehler gibt ist Java installiert.

### Server Start Datei erstellen
  1. Erstelle eine `start.bat` Datei im Server Verzeichnis  
  2. Inhalt der `start.bat`:  
     ```bat
     java -jar paper-1.21.8-60.jar --nogui
     ```
     Der Name der Datei kann variieren: `paper-<version>.jar`.

### Starten des Server
  1. `start.bat` Datei doppelt anklicken
  2. Beim ersten Start des Servers tritt ein Fehler auf
     ```
     You need to agree to the EULA in order to run the server. Go to eula.txt for more info.
     ```
  3. CMD-Fenster schließen
  4. `eula.txt` Datei im Server Verzeichnis öffnen
  5. `eula=false` auf `eula=true` setzen
  6. Erneut die `start.bat` Datei doppelt anklicken
  
> **Note:**  
> Der Server staret nun ohne GUI. Um den Server mit GUI zu starten, muss lediglich in der `start.bat` Datei der zusatz `--nogui` vom Startbefehl entfernt werden.

<!-- Back to top Button -->
<p align="center"><a href="#setup-guide"><kbd>🔼 Back to top</kbd></a></p>

<!-- ↑ Paper Server einrichten ↑ -->

<br>
<br>

<!-- ↓ IntelliJ einrichten ↓ -->

# IntelliJ einrichten <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/IntelliJ_IDEA_Icon.svg/768px-IntelliJ_IDEA_Icon.svg.png?20200803071016g" width="40px" align="center"/>

### IntelliJ fertig installieren
  1. Falls noch nicht geschehen, IntelliJ installer doppelt anklicken
  2. Installer durchlaufen

### Installieren des Minecraft Developer Plugins
  1. Wenn man IntelliJ öffnet, sollte man ein Fenster sehen in dem man ein neues Projekt erstellen kann
  2. In diesem Fenster **links** auf den Plugins Button drücken
  3. Im Plugin Menü nach dem Plugin `Minecraft Development` suchen
  4. Auf installieren klicken
  5. IDE neustarten wenn man dazu aufgefordert wird

<!-- Back to top Button -->
<p align="center"><a href="#setup-guide"><kbd>🔼 Back to top</kbd></a></p>

<!-- ↑ IntelliJ einrichten ↑ -->

<br>
<br>

<!-- ↓ Erstellen eines ersten Plugins ↓ -->

<!-- H1 tag da sonst der Anker Link nicht funktioniert -->
<h1 id="erstellen-eines-ersten-plugins">Erstellen eines ersten Plugins 🛠️</h1>

### Neues Projekt erstellen
1. Im kleinen IntelliJ Fenster auf `Neues Projekt` klicken
2. Auf der **linken** Seite auf Minecraft klicken um ein Minecraft Projekt zu   erstellen
3. Daten des neuen Projekts angeben
    1. Name des neuen Projekts angeben, z.B. `MyFirstPlugin`
    2. Location angeben. Kann frei gewählt werden. **Nicht** der Server Ordner.
    3. Als Group `Plugin` auswählen
    4. Als Template `Paper` auswählen
    5. Als Build System `Gradle` auswählen
    6. Als Language `Java` auswählen
    7. Als Minecraft Version die Version des installierten Paper Servers (in diesem Fall `1.21.8`) auswählen
    8. Main Class zu **[domain]**.**[package]**.**`Main`** ändern
    9. Create klicken und abwarten

> **Note:**  
> Domain kann z.B. `com.max` sein. Das Package ist im normalfall der Name des Projekts.

<!-- Back to top Button -->
<p align="center"><a href="#setup-guide"><kbd>🔼 Back to top</kbd></a></p>

<!-- ↑ Erstellen eines ersten Plugins -->


<!-- ↓ Zusatz ↓ -->

# Zusatz ➕

### Output Ordner der Build Datei festlegen 📂
1. `build.gradle` Datei öffnen
2. Diesen Code ans Ende der Datei anhängen:
    ```
    tasks.jar {
        destinationDirectory = file("Path/To/Server")
    }
    ```
3. `Path/To/Server` mit dem Pfad zum Server Plugins Ordner austauschen.  
   Zum Beipspiel:  
   `C:\Users\Max\1.21.8 - Server\plugins`

<!-- Back to top Button -->
<p align="center"><a href="#setup-guide"><kbd>🔼 Back to top</kbd></a></p>

<!-- ↑ Zusatz -->


<!-- ↓ Projects ↓ -->

# Projects 🚀

## Sample 🧪
[💻 Zum Projekt →](./projects/Sample/)
<!-- https://images.weserv.nl/?url=https://avatars.githubusercontent.com/xNiloGamerx?v=4&h=30&w=30&fit=cover&mask=circle&maxage=7d <- Das ehrlich cool, bearbeitet Bilder quasi live -->
- Author: <a href="https://github.com/xNiloGamerx"><img align="center" src="https://img.shields.io/badge/xNiloGamerx-1E242A?style=flat&labelColor=2C343D&logo=data:image/png%2bxml;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAACXBIWXMAAAsTAAALEwEAmpwYAAAE+0lEQVR4nJ2W228UVRzHz9xndnb22ha6FAsBWprSFKG2CAWBBDBWW6UNvEAiUZ5sKglV2xgDogQFBDEkiCYYE9T6B6j/gI2X+IYQjZGEykNrlKQ+EKrJfv2e2dnt7nanu/Qk357tuczn/G5nRogamheNatQO6j3Pdb9jP0P9G2gmGDtPbZdra3lmNaBDjVF/UqhRM9Fo9FW5d2lQ1z3AzXcfAlgq151iP/QwVirUSSq7ZOi85DPeodRqUJVu+jK/MeZ5S4aW7Z1YFM7JM8WbbdsGhytKURRf5WP533Jv2WHeXiymJYtVVa0MDTlM8ZzcW8Htg+WWOkEy1AT2LTINtGRSiFqG/39dzEF93C3My72xhSG4y1BGisHjleJUDs5bY+oaUqaywPKkIRDRQy32JUstD9XC6nQBmDFUqZgi8NXENXx4+WJh7pn+Afz04w/o7lgDR2OsFTUsOaf9S4Z/ngjLzHKwQUub0y6uf3wFswAuTnxdmHtpeBiyfXL6FOo9Fa5lSuvCsr5Xgi/UAjZ1BU2ewKYNLT5gz3VADHwDJ5gfPnbMHx8xdHQnHeiMveeGgs9J8PfVwLqqoKUxhUzbFbidv2Jj329Yte8/iMdu4XSiH7e45udEGvdaW3FT13GD4WjUNFiynis/e1KExVdKC8DNaQP1de2w228i2nkXRsd9JDpnCQYuJYdousBtxcAs+1+odbKeuTcR7uppCZ6rZrFlGH4Gq9Y6eB03kOjJIsVebAPeXzaMvzk3pZr4i+vbAtdrIVkd6EFN4FxGa7kyMVcituk20l33ILoe4PLyY77Fv9PizcFaXa6vXMcl4FBX58GFelVyl4Vqr0VyAy3eOIOry0dwn2PdwZwRfnOVuTr3El80xqXKu78RYvM/eKvxOHqDQ2lF6zQm1yLgb6XF58MWSFfpmhYK191uqImnSkPBw1qmuRhU6l0J3l4RylvHYFIVrFb0eajqIkHZQoMZuNcuConrONXAW/NX5kz5pK4b8xYG8XOaL8Fw2iGstXjDbsErHOvngXaxv5q/aPKuZklFXTfsysy9m4NvpIKlDk9cckdrcZipAejeTtiNoxCxnYjH96Cv/gU8zvkLdDNv/kJWq0FvWVal+/p48dvJpu7kwDE4tg7FaIJqNLB8MrmHZF6HzZpV04ewvOkUPqXFj6T2Y3+yz0+uLsIT0itUmlovf/NjoBhMA//wyj8COTBEZWNeHI5JV8V2M3keheF151wX6YDlboJYNoKB+F70NRzFgbojPvRNxn0osHI1JS+RwwvBWYKfE5UaJ08XwNHt0OlOnW71wd4OGLTWqT8KsfIMRgnvcHvwMucOEvw5+06qntpRGXyqIjQAq3T1hGPxvWu3IbLmM+jRrkKsrcbXeIBeCGMZ1mfG8IFeh3GOb6H6gjUZ6nnqSZnt8+AvvGpfmrFYSrE1cdJedSVrMH6auYLlE4FJF/vwFSfgrv4IIroF61KD6ODYIVp8IoitjPMItVXWuW1n455X/fO2pOl1g4oam1IIFarNJGuCmT4II/kshLcbDZFOjNL9/bzBZHzHhVJ4Nydyh7hj2XblmFZrkcyIbST2slzFtMb61Wml6e2CiGzAi00nWVa7MJB4GvsIGmVWH86Bp+n60QNC2EuCFjdVi6j2yrO9qtV8znB7JoXTOt3jtM/1Jgfnxgg6ItTJy0KcdYXYJpfX8sz/AYYRc2N60enJAAAAAElFTkSuQmCC"></a>

- Minecraft Version: `1.21.8`

- Template: `Paper`

- Build System: `Gradle`

<!-- Back to top Button -->
<p align="center"><a href="#setup-guide"><kbd>🔼 Back to top</kbd></a></p>

<!-- ↑ Projects -->


<!-- ↓ Contributors ↓ -->

# Contributors ✨

<table align="center">
  <tr>
    <td align="center">
        <a href="https://github.com/xNiloGamerx">
          <img src="https://images.weserv.nl/?url=https://avatars.githubusercontent.com/xNiloGamerx?v=4&h=1000&w=1000&fit=cover&mask=circle&maxage=7d" width="100px;" alt=""/>
          <br />
          <sub>
              <b>xNiloGamerx</b>
          </sub>
          <br />
          💻 📖
        </a>
    </td>
    <td align="center">
        <a href="https://github.com/xNiloGamerx">
          <img src="https://images.weserv.nl/?url=https://avatars.githubusercontent.com/OWLLaurence?v=4&h=1000&w=1000&fit=cover&mask=circle&maxage=7d" width="100px;" alt=""/>
          <br />
          <sub>
              <b>OWLLaurence</b>
          </sub>
          <br />
          💻 📖
        </a>
    </td>
    <td align="center">
        <a href="https://www.tiktok.com/@dennetic.mov">
          <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAACEzSURBVHhevZt3nJ1Vtfe/a+/nlKmpk5AeUiEJCS2FFqSKggUQLkFBEaJIuaAoV6IUc1VQQQNIBCkCXogkdKQIN4q0hIQAgZAykz6Tnun9nGfv9f6xnzMzBOTq1fuuz+eZc55znvM8e639W2v91tp7hP9jqaxcOfTJJ587ouqVPx68pmbPAYPGTB554snHDRw2ZFAfI5JpaW6mqamxs6G+tb65rXVXUVHR5qnTpq4ZOnTYSlWzZNy4cTX73vNfKbLvB/+sqF5v1m85Z4bx7izv/KkiZuye3bVccOaZnDFjHCX9+lHf3kpHXhGgJBuRRjE+JpWKaMsr67fX0yxlHPGpE/ji6Z+rKilNP2swi0aOPHAp4Pd95j8j/zIDHD18eJ8vfH7aRc+t2DR74uHTx44ZO4bykhJa29rYvXsvf3j4EYrjFkZU9GJQrwiJQNWS73SkDUTG4MQBQr/+vRk5pIJdrY7F79Zw+rlf4/NfOJVPzzxuvevo+O3AsdPuee21Z+v3HcP/Rv5pA2zZsqVP3jV978pLvntZ6Z71ZeMOGEZxaTlt+RhVIZu2ZI0nnRLa2zvYvaeelrZOMIJVQ0nG8ulpI2jq9Oypa6Wquo76thwKWIEDRw2lancHbWXDWfP+e3xqWBFvbO9ovuaGG349afKom4cPn1S375j+EflfG2DhwoV26tRJ31T1c42RfhvWb+WSr36dQ4aVUVZWhKCIgBETfqCgKCqCqhJFlkNHVjB2RH+8wI7djayp3MaQIRWsqNqBGIOqgiolmTS2qJy7nn2TT4+pYMSwgby+M8c9v7untld55rqly9fcdfbZZ7t9x/j3SDK6f0w2bHh3XFtbw6vf/c4P73j77Q/6bd9RS+wdBxw6lTcqd9HY1ErGBvMqBKWNgDFIsArDKnpRWp6lMx/T1tbJe5XbqWnqZNm6GjR5joggxtCSy9PaUMtnDhnJql3NtLS2MDLdwS0339ZPxN4xY9qEV2tqVo/bZ5h/l/zDCNi48f3zQea3t8UlXz9nFjPGDyAft5PNZBjap5R+JZYN1XW0dXRgo4j2nCfn4q5HiSSPVCVlhKEVZQwdUE5ZWRHPvLIaL4Ig3dcF8CCqRMaweUcTwyvKiF3Mkg11LHjqSfr0LUFVWkXlkmGjJjzY9cO/Q/5uA6iq3bx5zS0gVxhjMCbFkiXLuO7bVzKoyFKeNRw0eiCHjxtAOp1GohR1be0s+2AHOR+CG9JtANXwx6MYIGMNOac41QD9jxGjkBYl7yDnHJt2t3DulXMoKc3yxutLcU4pKiq5dfoR06/6e13C7vvBx0llZWXm2GNnPlKULfvaqFGjyGSLUCCVitjd0EJd7TZOO/pAyowjzhtS5eWs2VLH6vW76FWWYr9+JbR1OpwPcUEBRZJXEASfzIVBCNHiwyLJ4QRAcd5jxfKHZ14k2vMew1ItNO7cwjMvLJ5x/3/94aBLL730yWXLlv2PRvgfEVBZWZmJoo4nfzL3F6e4beuoz3mczeDzOQaUp5i8f3/amxvZWL0XnDJx1EC27WyiNXak05ZsZMnFOfJq8PhEWUXVoBpSuuiHXWNf5XuK+IAQVaW1wwFKGseqBssJp53GxEkTscYwY/ohL8Q+88Vx48Z17nuPnvKJQVB1obW2bYGIPWX2t77Jsg27GVbkmDY0zbQRxfSyHayr2srm7Q3YKCJKp1hfXUdn7JDIkHOe9nyMikWMQbCICAaDqAbF99H2k5QH8AKIIAbKSyJKMpYV25rJpiI2VFaRTmc45pijiVKZU9Lp/AJV/USUfyICqtatmBdFqSuMjXj19Tf51uzL6JWGmQcOpaw0izESaJn3oCHlWWsRI3jvyDuPd46S4ixOlYaWTupbOvCxkk1ZSksyZFJCygqSpEvvPT5JoSLBYCKgqjgf0qJBgqOokrEGG+dRkyJdXMo7m3cy5YQv8O9XXoxqHu/11pEjJ1y5r24F+ZsGqFq3/HxjzAPGpDDWgom46CuziWr3kI066VueBRGMEWwqpDcxgokiNO+oa2yjozNmYEUZO+pa2bi9kdLI0ruoCFFoy+do6cjR6j29y7OMH9CHdJQgwEC7h/KSFIhgjaDe412MUxOQAzjvIR+Ta89R25Sjcm8LJZHFGcOVP/4JJ550DN47VPX8kSMn/n5fHflbLrBh9ZvjRGW+JF8rijXC57/0JdbVN4bZMpZsSTGp4gwSWSQyeC8017awvaaJnbWtDOhbwsbqWvJNOaYOrmBsRR8UqG/voLUjT9ak2L+slIp0Ce9W17FpVwu5jpgPqmtpzcVYI0QW2uvbqdxYi5UIYwwmQcrAPsX0Li1heEUvyjIp+hZnKBo1gSnHn8L8O+4KIVUMIjK/ZsPH84SPGGDhwoVWjbnfWFMS8KHJZUJrWzMNDY28tHorSyt3sqOmjpbaNlrrc9Rvb2FvTT3NTTk6Y0/f4gz1e9spsyn6F2dYu7uOnX4X0w5p4eIvKtd+Fb49y/GZmc0MHbydAeXtrN65i1fXbydKWfbvX4oAtdtbeGXtTnr3K0ONwRrDxKF9KUqnGDOkF1Y8Ff1KKCtJMbxvCa2b1/Gp42Zy5123AyBisJhSb/39qvoRfT/iApWrl11irb1DbFDaGIOxEcamAcuF530du2MzWQuRREk60yTCg1fDB3vqqSjOMLi0mFg929rq+M6ZEYeMBpNyZIo9JuUxBsAy9y5lR71h+27L8IpeDOlTQlubY8ueVt7fsYfRwwcwZURvVGFw/zI0r+zXK8PG3S1MHNGHl9/YyLDBZazeVE+slk15yzMvPgsSd2UMcXnUu0uHj54yv6e+H4qQq1a90dca+7gRKRYTApMxBhELYohSEZ857TSWrF7Pex+swaCIEWJV2mNPTVMbe3Mt7Grs4JCBFXQ4z472Pdw62zF2uKdirDJwVBvlA/KU9Ysp6+Mo7e1o6izmtbctbe2eXY3trN/ZSCvtTDvY48kwYehAvHpUQVBqG1roVV7C1r3NWLVs3VFPXVMH6sNkNDa3MGTsAew/alhAcJJmvfoZF80+75758+9tL+j8IQRUfvDmT8WYa6y1SYAziDFgIqxNjiiDEUvNth2c/5Wvktu5jdZ8zAnHpThpsuF3T+fIdPahrdPRaeq55QJL/4HKkMmQyXSAjxOakxQLAu17M9RtydLYZOnIpchkhWxZjrJhhtMujjlyzBBy6hJnDBkABFVHPudpaegIKPRCc3uexs4ch33281x3/RxilwP1iIL3MRrHNw4fM2XORwzw3nuv9imKslsQyowxmMgiCNYYkAixBmsjjM2wYeNW7ph3Gxvf+CuDyktZtaee++79LOec9wil2TKKixwnHgLnHm0pr1AGTewgZV1gc5rk8oJoaIyoMagYiBURB8bhfTFHnJll6qhBuJBnQwYwAhqqynx7juamHIhH1eIV3ttex6TpR3DXPb8mdjHgEA9ePbh8UyxuxP77H9JAzyCYsZmLxEiZMQaxSVpLBioSrO69oupYv24tTbW7KR40hB2NTVQMG8FhU6bywk/S3P8faR6+NuLS01MMOzDHsINaSNlcF731Eji9JPc11iKRYozDSg4becSAUYNqJ/vtp8QFduTDGw2oBoTYaxiXNwlBCrmrI5dLMkDyW/EFmlUuamYnnwYD6PXXG2NlNgVle1RiBZCoSJg+hVNP+wz3L1zAfY88QmnfCiYdeig2WsUBxysHz6xnzKHNDJvSSO/BHYhxIKBigg+roKJ4k2bdtmJeXF7E4hXlrKvuQ15KwRrEWhCLEeH0kw1V2xoJya9QRAkQSmWfD4WWV4hjz6Y9TRSlLZMnT4YkhhXEJFlBYLaqSpd2a95fdmQqZV4v1N9iBCPhIUYMYqLwuTVYm8FGKaIoQlVZtOgJxAgl8e947dU1NDU79uufYuY04dNHdmJNB6gF7xEVvKb42QNF3L2wja3bO7rIrwj0Lo049YRyrr0kYsygZlSVjtaIL11hoL0fgyuyQRFjwRisGOp3N5CPDU4VRFi+eTcDi7PMvfseZkw7FKcxzuVRdYgq6lxgm06OGjn2oDcMQBTJWRRA2mPyRQQKHR0IKVEMxtiQX21EY2MTjz/6JF+5+E1+81AjDz3dzC331fPFi+s5ZXaEShZVH4KX9bRLlvufcFRvbwdRioqKKC0twVpLQ3PM48+3csOtFm8D388W53jgBmjTOt7eUFeYQUCJ8zEuNqhocAuvtOdytGGYMmVy0IGCO3dXnwDG6lnhe6Bq7fJKa+zY8E242BiLkaCoiIA1RFGEtVnWVVbx9FPPhS5uSwOa6yRlhDiXozXXyY7dDby38i2+f2kZF31xG+I9GMvjfynjjVVHkNIyyjJpiot6EyVdImstjc2tNOU6SZVkybe9xunHbOOwSY1ITrn4R8Wkc+PxPocn1ASNte3kcopTn8Qn+NPaLXzh9NO5665fo+rwXvGawzkXMpAP9Ykq60aMnnyAVFYuHWo1qu5qVwG2xyx3+ZE1RDbi4QWPU7t9G32yEe8sX866qio8jo52hxWLFRjQry+HTj2Md9a8x5SDqnEuTXun0qvv6ax9bxWbqzfQ0hGTLu3DQZOmkC0qoqW5iU1VldTv3s2g8lKOOnIGncUltNb9NzMmt7D4daWE/bHqUK8017bQ3ql4CbQYBw0deUZ/6mTm/OBqevcuQ0RRpzgf432cGMGDy+NU1cR+mFStfessVBeKMRgb4B4MYMCkQAL0xRg62nNcduE3KOtoZsn6aqYceSyXf/sKbrrhG8w87it881vfJNeZY+V7K5l/6zzYVcOJp5xAPlY68zEvvPRnKrfv4EffG8buzjP54fU3EEW2EFtRVX575108fN9PaN0LowdVMHziZPr378+OhlZWvruCuGEP/YyQFoNag0Px6hEPq/e28MTivzBocP8E7A714L3DuXxiKAWfJ1aHIGdL5erlPxFhjpiQkgCsEYxY1EShGrMWayOaGls4/eTPMKA0xfvVtUydeBCNznPojGnMm/fL7g4wsGvXLk45/DCKs5amTmXMkD68u2kbI4eVMGLcwdz7+ycwRpIOUBiuAKqOa+f8B0sW/4F+ZgBLqzZTni2noryMqdOmUjpoAOs2b+HdV/7CyN4lZCODd468Cplxk7n3/vtAHKoO1IeA5z3OxaEydB68w/k8iv7USOQPAO2CvyRta1WPaujgBBH69O3N9E8dT2N7TBRZ1m/ezpb1lXxj9kVdXGHBwws46qij2VpdQ1RUhDPNzPtPoWZ3LT52bK5p4XNnfhUrQXlVZe7cuUydOp01a9YiYvnWZd9hxeoGGlrayOVjzpjRirM1PPTMkzz28EKaNm/lhJM/w3bNUN3UTmQNm+qbuPTyy/GaT8ZrkmowkKbudJ4EwpBODzDqGSkSWtUkMFRCo8MkLaugPohEZDJZvPMMGTqUhcteY+LRMxk6dEiXoX75y1+xZMkbPPzwAjJFGcrLI4bsB+IcRmBXbTMTJ07oMrj3np/97GeseGsZjyxaBMCQIYMp7dWHPOE3MycoR4yFA/qWk9YO3l6ziqf/+CwlDva05NnREjP60OkcctjBiEiAOt18gWR0Xdkgac4KOtKINwML+eHjurEhIwRoC4Z0NkNROkVzQyO9Bu/H9OOOY+3ayi6cXH755ZxwwklcOPtCmpqbcAJWYmKvZFMp1Hvqamu77m+M4fvX/ICTTj6FWefOAiCfz9PW0kxH7IiMYczRpZQPSVNalGJ8RTnThvYnZZTd6ikbMIClW7Zx2RX/jjHd41cFTNJzFAKPSQxQyGyKDDSK9unmi3QTk0SlbioZmOCIESOJrKG9uYUdNds5/nOncvfd93QZ7/zzz+PFF19gzapVVIwaww9uuIL+vZVcHALVmKEDeOjBB7uuFxF++MNr+NMLzzFuzBgAXnzxRTIC7Z0xpWUpBo8SMuWWyBg6naOx70AefW4eq14+jeUvnczSV+Zx/333sXtXfRfURYILF6KLYLuZf8HdoY8RkUz4tFsK8KRAHlQTOClTp00lHzvy3vPqc39i2Ij9KR00mNt/fUcoNlDmz59P9Y7tvPD4dzlm+O2UFzVTMThNWXGGfGdMNn6V+x94sGuA3QshyqbNm7hv/rWMGNiHts4c+49MY30zxjlaXMz69g4euPt0DkxdQX7372jc8iBT+s3h51c38+Prr0m4iwQEhDsnWgWYB4cIrBHIGNUQALsx0AMNBRJUEFUmTppAuu9+DOvbiwdvv43Whgb6DqigdvcaZp35aW666Sa2bt/BZV8ZiG76MtY3IpLn+KMd5aWlxAri22jbej2XXXwhr7++lPr6BjZs3Mjtt9/Oz390MkMqdlNaVEZnnOOIqR46PQN7Razfs5czTxMGtv+Yvy6F0y/2TD21hT89XcqgosUMkMVs2rwFBFQF9VAIY0pi7J7qAFK5elmrtba4S9GECQaqm0Js0so2hsiksak0S5e+xdUXX0zaCK53P8orBnDxrMPJdNzLrb9zPPTo8/Rr+iJpXxfCqXj2tPXi1POE0nRfPthcw5XfLOXUE4p4fUVMze4Ym4L9KuCdlTEbV/djT2MLJpXnpf9K0be4idamFL/5A3z+RBg+wHHihcqCG0tYVSW8v7yVb//A84cHDTLpFs444/NdKU9VQyrUOEmN4XMfxzjv26Ry9bIaY8wQkWTpqitYJN0gm0YEjImITIRJpbA24q8vv8YN11xDqrOdopSQjz0uVppTad5Z8p+YnReD5rrwZIxlxfpeXHhVTFmqL3E+T0tHG0YcRjz5vFBaVEJFnxKqdu2lvFcnv7q2iOkTW0DBOAX1KDHPvFzKQ084mpqE315XwsplrRx7muWRR5Vo8i/40pc+nxQ8oSXmfVBeNTBBTXiB836brFuzbIUROdSIoOIx2DDrST/Q2kyhjsTaFMZEGGOxUYTz8MZrS5g37zYmjh9Kqu0Z3t+QZdGCuZQ0Xong8EkVbQFvDI0tWX63SPnzm5adOyJaW/LB7UQp6204YLTnnFMNx83Ik6Yz6SIEXmKSwLlhaxFFYthZrZQVe0qKHdmSND+5Rzl3zkuMGzcyIMDnUdVAgfF470IH0zm8c8TOvS1r17z5mMWcIRI6FUZATKorZUQ9DGCMQYiIbAqsxUYpjBF++IO5zL32qxRvO5E/vZHmjQ/G84NzV1Lc16GF1OSVrdVZhu6XSwYiOCmiM07hnZC2YLUDIcagqPUYSZQXxagioRmA5g0tjWnqdgN4+uwn7N6a4ju/H8dDjz+H9/lQ9Pg4eL93gdh5D3jUxXjn8d4/blDWdmXPD/WqQtDz6pPE2L1qG1oJinpPnI+pra8nG20DyXPKUS2UmnX8+w3Cy3/KsmZlCS+8kGX2nDR/XpYKJEUUcFhtpcg0UJxpIGUbsdKBEYdKmKnkwaGNpvDu2lLe+aAMtRlKesGwMdCvHzTtMMx9OMPV192Iahyyi4bsAiBik0YKeE06SKqI6Fp72eWz+4lyVpjxJHEUiE9w/qQnkCBAosD5Q8jgV/Nu44x/O4Ph5hZs52bwnqMOzTNgYDHPLc3xygpHToULzsoy87CGcN+eCSqcgCQQF7CF9Cs+fKcgXti7tZhv3xITtxh6p4SGvZaX37Lc9FhfLvzeb5g67dAktofJU02sl6TwQiYIL4oit0tl5dKhmpdqm0R7ESGsCYApsKYoHZohxmAlBcaCwKZNW3jm2ReY861+RLu+j2iIuiEFRai3JB31AD0cIhLiAqE3GBQFQTE+NGAefKaEow737D+guYu2aj5i4wrhV39M0XfiRaxbvYpUKs3hM47g3HNnUVpWFFxLXNDRJWVyYb1Rc0lAVNTlUR8jkR8qAGtXv1lpjRlrRKDQFpMwR8YEAxQMZCSVLI0Jjz36FAceOJbpfS4hojpJupIYIJnnZPlXpbvg0mTSu0URDc3QvW29+Ob1EdPGOq76egMiBjWQa4jY+oHhukcy3PnoB6RTFjEB2kpS6WlggKgPawQJCrzGIS6o4l2IAeriyhFjpow3BDQ8W2BlqiSVYJfnJ3AKh1eXMEM4+OApLFr0BD57ACL5hGT4kDatx1iHGI+YENAEH2o0ke73KJ6I5WtKuepXpVzwfeXfz/VcdUErgu0yVmezR1E64yyptA2A1hgl3w37JE4FHQqf+ZD+KHyW6CnuObrIsZFFhZkLygboaOGGYYU1ORyqMahn9Jj9OWbmTGZdVc89j/ZiQ3UJjlLE2K6OUngfGipiIlQyNLSW8dbqXtz9VDEXzS3hjCtLeOply5c/l+GJ23IcNaUlQBmPSKCvHW0RJjKILQ56JRniYyVEaSCsBXSPPZlMPFgWUUDi9ddfb2ad/dl11pgxBZiaqDsmgMGaCLFJd1gUa9KICXsBnBP+8pdXef3V19iyaR0+3os1DRgf0lp7zpNJW0SFOO8oK8kzfrTh4HERh02yVPRuQ8mHIKhJlijMYDKGLSszdHZ4rlkwkgef/EuP2e42QlDQo4VdJHicC74PoLFDfYxXVzV8/8njRaTbVGs+WPo9Y8zPbdLV6V4c6abGJgr+LyJYG/XgCxYhxAXpWlIL7bR3317JKy//he+e34w03RHW+hUCcl3o2xUgm8SJgvMJwR42slS+GeG8cO2jo7n/sf9OoL2PEQro7fL7uCsQqgre5xEX49RfPXLUlF/QXR9C3uXvUdVmCt2hLsNqcI3wtut9cJcwcFWfpJiQfwMNzePjPBMmjGPF2yt4+f1DcL2+h48N4mLQPD7p2kKg4BAKGPEgasL7BO0+TviI2GR7VU8/DxLiVWFM3YYJyjvEezyuScXfXfhNlwEmTz6mHuHXyXh6QKxwXoBY4QHdhEN9CDTquouOwMI8qVTEnXfeyabqBq788TZ8rwsCq1G6iIomLC+UxckaIQQPTRDhnCImpr52B4sXv/KRPFIYbwiVyaT0GC/qUO9wTu8orAvS0wAAsXM3e7TW++BHhbW4LjioB7ojatiDk+t6WKi2Cv4bDlUlW5Rm1rnnUFvbQK7ki+AK9Xq3hFOTLMElRKEwq4mIKvlcB6+/9DJPP/V8SMeJ9ERDVz8zGUbobSpetTbqaL+568J9DTBp0pF1KNdpl4KalJQFBUNB0Q2tAkryqM+Hh/mkE9NliHDdxg0bWbvmAzZuzRNrgHtP8cn2uSBdDYuue1grWBGKsqWcf87Z3Pvbu2lv7+ihePf1XROBJBsvw3KYgeuGTzryQ5urP2QAgPdWbb7L45ZQULDLFQqKJXDv4WOJp0Jh3veBXl1dLTf9/Oecd/751Dd0opQEmkviBj1nkqTo8UkskrCYarPClr1Z+g6eHPYKes9Xv3wBy5e/002wevo/4HFhC2YohJYMGzX5zq4HJfIRA5x99tnOq3zNq2+Fgkbhuy5k+xDoeipeuLRbus9u/OnPuP66G1iyZCnOeZBUKDAJEU4IdNeElbyu88ADApss7pvll0+m+fp5X6O9s4Pi4mJ+9N2reeC393LTjTfjujo/hG07KsGN1aHqWxz6NZHE6j3kIwYAmDBheiXoJYVzTXJrmJ+ABtTj3IeR0NNfEaivb+D737+W999bxYEHHsD26rX0LRfEd/ZAT/I7DeGr52tAgIKBu14ynHLGdxg0cACPPP0Ep558Cpko4nvfvJRBZb35+lcvZM/e+m7UJONy3uHUXzp69MGV3YPrlo81AMD4CTMeRLk1+GMS6b1PWGHy6h3eFxYguxtw3nvuu+8BZs06jz59+jJu3HgEGDZoMKPSN2KkERHwRhNUdbtW8B2S4gjy+RTf/UU5ow+7iSu++21a1NHQ2sYx06fhcXjyHDNtKt/4t3O4ZPa3WPXBWqQwVaoo/tZRow7+mzvI/6YBAN5ZtekqVX2ikNs12Y1RWG5CHc4lCFBBMFRvreayy67kwAkTGTxkMN+fM4d8Po+inHfRZdx023qQdFIjgFhFjCIm/IeIQTHiUUnx4ooSzp0znNPOX8AFF3yNbdu3c/udv+H238xnzOQJlJSXdSFp6OBB/Pjq/+Dnc3/G4v9+JTGCe2L58sqr9tWrp3ziPtpFixbp5Vd870n1bYeLyBgS3wwH3UvnyfnrS5bx4O8f5rbb7+DtFW8z4aBJTDv8MN59dyXZoiwnn3QSW/b25Re3v0lZsdCvT0RxUbiHkTSdLsP7lREPPZ/ilwuGUTT0cm66+S7GjR/PsmXLuO6667jjjvn07t2LTFER/YcMJlOcpb21Fecd6WwRx888lnvufYBY/fMjRow/a+bMmYW1so+VD+eivyGVlc9lvOu/wIo5XSCsInf1DiKMSfHkU89TU7OdH//4p7Q0NXLe+efzxFNPEVlL7d69nHPOuTz44AMMHjyIPXv3sHDRYyx9/TVam3eRTnmUFKlUORMOmsLxx53A4VMPx0SW9rZ2bv7FzWzfUcMtN/+SktJk/yYQHMVTU13N7357L+vWrMPl80w6aPITDzzy0Kz169d/4k7xf0hUF9qq1cvnVa1ZrhvWvaUbqt7WjetX6uZNq/S223+pc+f+SJ2PNdfZoT+6+mpdsGCBOvWq6lXV6bp16/TEE0/ShQsXaS6fV++9eu/Vea/OO3Uazr336pzTDRs36k9vvFE/+9nP6nPPPaveOw0S7qfqdNPmTXrhRRfqZZddps8//5xu3rRB//rEU/POOuusT0R2T/m7ENBTqtYuOw+V+WJMqbHCsuUrefWNt7h13jyssWxbs47zv3Uxz730EqlUhOnKDEJraxvz5/+GxYsXM3ToUCZMmMCAARUYY+ho76C2bi+VlVXs2LGdwYMHM2vWLI499tjE1Uhq+TDkxx57nMcff4KbbrqRIUOHIdDivb80iqK/GfA+Tv5hAwCsXv3muLSx9+/ZW3fETTffwYJHHiGbztBSX8cfFy5idU0NP5r7nwmj/XDqDelJqK7ewprVa6ivr8d7JRWl6N+/LwdOmMDA/QZ9iAfsK08//Uf+/OfF3HLLzaEixS8B+Zox5mNT3f+JqKo55ZSTLqmsqtyr6tX7WNe8uVy/fMaZuq6yUn0PqO57eO8SuBfe9zziBO4ff1RVrdOzzj5Lc/m8xt7t9T6+5OM2Qf9/E1Xt45z76a6a6qaVL/1ZTzjueI29/x8MEJQMr/mPHB++LhzhPK9nnHmmbty0ocl599MG39B33/H8o/JPW05E6q21c7ZXrR++oWbL1YdPn14l0nOxNUhP5pd8krxKchTIcfcOlQ9f7dmwaUPVzh07rt5/5Kjh1tg5vU3vf+q/RvnfxoBPElUVVT0C3FlgPiPC+H2+73naQ0wS5ApS4HOsQ/V5EV0kkloihTbzv0j+5QbYV7z3Q0T8kapyMHCAqo4UYSDQB8gkBukEqQfdJSKbQdaImJWq+oYxZtu+9/xXyv8D+B0TY61FL1IAAAAASUVORK5CYII=" width="100px;" alt=""/>
          <br />
          <sub>
              <b>Dennis</b>
          </sub>
          <br />
          💻 📝
        </a>
    </td>
    <td align="center">
        <img src="https://images.weserv.nl/?url=https://avatars.githubusercontent.com/u/194209397?v=4&fit=cover&mask=circle&maxage=7d" width="100px;" alt=""/>
        <br />
        <sub>
            <b>Nils</b>
        </sub>
        <br />
        💻 📝
    </td>
  </tr>
  <tr align="">
    <td></td>
    <td align="center">
        <img src="https://images.weserv.nl/?url=https://avatars.githubusercontent.com/u/194209397?v=4&fit=cover&mask=circle&maxage=7d" width="100px;" alt=""/>
        <br />
        <sub>
            <b>Daniel</b>
        </sub>
        <br />
        💻 📝
    </td>
    <td align="center">
        <img src="https://images.weserv.nl/?url=https://avatars.githubusercontent.com/u/194209397?v=4&fit=cover&mask=circle&maxage=7d" width="100px;" alt=""/>
        <br />
        <sub>
            <b>Lukas</b>
        </sub>
        <br />
        💻 📝
    </td>
    <td></td>
  </tr>
</table>

<!-- Back to top Button -->
<p align="center"><a href="#setup-guide"><kbd>🔼 Back to top</kbd></a></p>

<!-- ↑ Contributors -->
