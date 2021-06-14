# common-kotlin-lib

A custom gradle plugin that automatically sets up common kotlin plugins, dependencies,
and other configurations in a highly opinionated manner.

## Motivation

The `allprojects` code block has some limitations and is discouraged in use by the gradle team
mow.  This is a way to have a lot of boiler plate code in a projects build script
removed by simply applying the plugin in the plugin block.

## What it does

The main jobs here are the following:

- Automatically apply the kotlin jvm plugin
- Automatically apply the kotlin kapt plugin
- Automatically add depedencies
    - kotlin-stdlib-jdk8
    - kotlinx-coroutines
    - kotest core
    - kotest assertions
    
Future work will do the following

- Add kotlinx-serialization plugin
- Add more dependencies
    - serialization
- Add ability to make a custom block to choose versions or deps
- set junit as runner
- set compiler options
    - target java 11/17
    - language level 1.5
    - Use IR