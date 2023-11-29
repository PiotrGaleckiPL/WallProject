# WallProject

This project implements a simple wall structure using Java. The wall is composed of blocks, and there are two types of blocks: `SimpleBlock` and `ComplexBlock`. The wall itself is represented by the `Wall` class.
## Interfaces

### Structure

The `Structure` interface declares methods for interacting with a structure composed of blocks.

#### Methods

- `findBlockByColor(String color): Optional<Block>`
  - Returns an optional containing a block with the specified color, or an empty optional if no such block is found.

- `findBlocksByMaterial(String material): List<Block>`
  - Returns a list of blocks with the specified material.

- `count(): int`
  - Returns the total number of blocks in the wall.

### Block

The `Block` interface represents the basic structure of a block in the wall. It declares methods for getting the color and material of a block.

#### Methods

- `getColor(): String`
  - Returns the color of the block.

- `getMaterial(): String`
  - Returns the material of the block.

### CompositeBlock

The `CompositeBlock` interface extends the `Block` interface and declares an additional method for getting the list of blocks within the composite block.

#### Methods

- `getBlocks(): List<Block>`
  - Returns the list of blocks contained within the composite block.


## Classes

### Wall

The `Wall` class is an implementation of the `Structure` interface. It represents the main structure of the wall and contains a list of blocks within the wall.

### SimpleBlock

The `SimpleBlock` class is an implementation of the `Block` interface. It represents a basic block with a specific color and material.

### ComplexBlock

The `ComplexBlock` class is an implementation of the `CompositeBlock` interface. It represents a complex block that can contain a list of other blocks, forming a more intricate structure. Because the `CompositeBlock` interface extends the `Block` interface, the class `ComplexBlock` also implements the `getColor(): String` and `getMaterial(): String` methods. Both methods return information about the color and material of the first block in the list. This is an example implementation that may change depending on th requirements and assumptions of the project. 

## Usage

To use this project, you can create an instance of the `Wall` class and add various blocks to it. Then, you can perform operations such as finding blocks by color or material.

Example:

```java
// Creating a wall
Wall wall = new Wall(Arrays.asList(
    new SimpleBlock("Red", "Brick"),
    new ComplexBlock(Arrays.asList(
        new SimpleBlock("Blue", "Concrete"),
        new SimpleBlock("Green", "Brick")
    )),
    new SimpleBlock("Yellow", "Concrete")
));

// Finding a block by color
Optional<Block> foundBlock = wall.findBlockByColor("Blue");
System.out.println("Found Block: " + foundBlock.orElse(null));

// Finding blocks by material
List<Block> concreteBlocks = wall.findBlocksByMaterial("Concrete");
System.out.println("Concrete Blocks: " + concreteBlocks);

// Counting total number of blocks
int totalBlocks = wall.count();
System.out.println("Total Number of Blocks: " + totalBlocks);
```
## Tests

This project includes a suite of tests written according to the BDD approach to ensure the correctness of the implemented functionality.

### Running the tests

To run the tests, use the following commands:

```bash
# Run all tests
./mvn test

