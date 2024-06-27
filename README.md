# Enigma Machine Simulation - Part 1: The Plugboard

Welcome to the third Domain-Driven Design master class! In this series of Kata, we will be implementing a software version of the Enigma Machine.

## Introduction

The Enigma Machine was a crucial tool used during the Second World War for disguising military communications. Alan Turing, often considered the father of computing, developed concepts in response to the need to break these communications. Turing and his colleagues at Bletchley Park are credited with shortening WWII by two years, potentially saving an estimated 22 million lives.

The Enigma Machine comprised several parts: a keyboard for input, rotors and a plugboard for enciphering, and a lamp board for output. We will simulate these components using strings and build the rotors, plugboard, and mechanisms in software. This project will progress in complexity, so it is advised to tackle the tasks in order.

## Step 1: The Plugboard

In this initial step, we will implement the plugboard.

### Physical Description

The plugboard cross-wired the 26 letters of the Latin alphabet, allowing an input letter to generate an output as another letter. If a wire was not present, the input letter remained unchanged. Each plugboard could have a maximum of 10 wires, so at least six letters were not cross-wired.

For example:
- If a wire connects A to B, then an A input will generate a B output and a B input will generate an A output.
- If no wire connects to C, then only a C input will generate a C output.

**Note:** In the original Enigma Machine, punctuation was encoded as words transmitted in the stream. In our code, anything that is not in the range A-Z will be returned unchanged.

### Class Implementation

The `Plugboard` class you will implement will:
1. Take a list of wire pairs at construction in the form of a string, with a default behavior of no wires configured. For example, `"ABCD"` would wire A <-> B and C <-> D.
2. Validate that the wire pairings are legitimate and raise an exception if not.
3. Implement the `process` method to translate a single character input into an output.

### Examples

```python
# Creating a plugboard with wire pairs
plugboard = Plugboard("ABCDEFGHIJKLMNOPQRST")

# Processing inputs
print(plugboard.process('A'))  # Output: "B"
print(plugboard.process('B'))  # Output: "A"
print(plugboard.process('X'))  # Output: "X"
print(plugboard.process('.'))  # Output: "."
