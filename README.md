# HexTechAutomaticPencilSharpener
Automatic Pencil Sharpener Using HexTech

# Project
An automatic pencil sharpener made using the HexTech muscle board inspired by [Projects With Red](https://www.youtube.com/watch?v=7P9160cqDPM). Modifications have been made to adjust to the use of HexTech.

# MQTT Server
The HexTech muscle board receives input through an MQTT Server. An **MQTT client**, the HexTech board, establishes a connection with the **MQTT broker**. When the MQTT broker receives a message, it forwards it to subscribers (the HexTech board).
