# Digital Clock (Java Swing)

Displays the current **system time** in a simple GUI.

### Components used
- JFrame
- JPanel (acts like a Frame)
- JLabel

### How it works
The time is updated every second using `javax.swing.Timer` (aligned to real second boundaries).

### Compile & run

```bash
javac DigitalClock.java
java DigitalClock
```

## Notes
- Time format is `HH:MM:SS` (24-hour).
- You can toggle **12-hour** format and switch **timezones** in the UI.
- No external libraries required.
