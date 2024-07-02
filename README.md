# HexTechAutomaticPencilSharpener
Automatic Pencil Sharpener Using HexTech

# Project
An automatic pencil sharpener made using the HexTech muscle board inspired by [Projects With Red](https://www.youtube.com/watch?v=7P9160cqDPM). Modifications have been made to adjust to the use of HexTech.

# MQTT Server
The HexTech muscle board receives input through an MQTT Server. An **MQTT client**, the HexTech board, establishes a connection with the **MQTT broker**. When the MQTT broker receives a message, it forwards it to subscribers (the HexTech board).

The **software**, programmed in Java, can publish messages to the MQTT broker.

# Software
The software is a Maven project programmed in VSCode using the "Extension Pack for Java" plugin. In the App java file, the user is given access, through a GUI window, to multiple functions used to control the machine.

**Manual**

```MOVE```

```RESET```

```SHARPEN```

**Automatic**

```AUTOSHARPEN```
