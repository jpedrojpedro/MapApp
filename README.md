How to run code through terminal?
---
  - Compile

    ```java
      javac -d bin/ -sourcepath src -cp lib/swingx-all-1.6.3.jar:lib/swingx-ws-1.0.jar:src/ src/controller/Main.java
    ```

  - Run

    ```java
      java -cp bin:lib/swingx-all-1.6.3.jar:lib/swingx-ws-1.0.jar controller.Main
    ```

Dependencies
---

- swingx-all-1.6.3 ([download](https://dl.dropboxusercontent.com/u/5796120/swingx-all-1.6.3.jar))
- swingx-ws-1.0 ([download](https://dl.dropboxusercontent.com/u/5796120/swingx-ws-1.0.jar))
