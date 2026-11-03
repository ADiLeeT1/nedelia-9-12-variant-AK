# Week 9 — Multithreading, Task 12: Bank Notifications

Simulation of sending training (fictional) notifications to several bank clients at the same time
using `Runnable` and `Thread`.

## Structure
- `src/NotificationTask.java` — task (`implements Runnable`), sends several messages to one client, uses `sleep()`
- `src/Main.java` — creates 3 threads, calls `start()` and `join()`, prints the summary at the end

## How to run
Open the folder in IntelliJ IDEA (File → Open → select the folder, it will import `pom.xml`),
then run `Main.main()`.

## Ответы для защиты
- **Thread и Runnable:** `Runnable` — задача (что делать, метод `run()`), `Thread` — исполнитель, который её выполняет. Мы отдаём Runnable в Thread.
- **start() и run():** `start()` создаёт новый поток и вызывает в нём `run()`. Прямой вызов `run()` выполнит метод в главном потоке, без параллельности.
- **sleep():** приостанавливает текущий поток на заданное число миллисекунд (здесь — имитация времени отправки).
- **join():** главный поток ждёт завершения указанного потока. Без него итог вывелся бы раньше, чем уведомления отправлены.
- **Почему порядок сообщений разный:** потоки работают параллельно, очерёдность решает планировщик ОС/JVM.
