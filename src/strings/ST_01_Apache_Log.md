# Apache Log - Find Most Frequent IP

## 🧩 Problem Statement
Given an array of log lines, each line starts with an IP address. Your task is to find the IP address that appears most frequently.

---

## ✅ Current Approach (Stream + Sorting)

### Code
```java
public static String findTopIpaddress(String[] lines) {
    HashMap<String, Integer> map = new HashMap<>();

    for (String line : lines) {
        String ip = line.split(" ")[0];
        map.put(ip, map.getOrDefault(ip, 0) + 1);
    }

    return map.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .findFirst()
            .get()
            .getKey();
}
```

### ⚠️ Code Smells / Issues
- ❌ `split(" ")` is expensive for large logs
- ❌ `findFirst().get()` can throw `NoSuchElementException`
- ❌ Sorting entire map → O(n log n) (unnecessary)
- ❌ Doesn't handle null/empty input

---

## 🚀 Better Approach (Single Pass - Optimal)

### Idea
Track max frequency while building the map.

### Code
```java
public static String findTopIpaddressOptimal(String[] lines) {
    if (lines == null || lines.length == 0) return null;

    Map<String, Integer> map = new HashMap<>();
    String maxIp = null;
    int maxCount = 0;

    for (String line : lines) {
        String ip = line.substring(0, line.indexOf(' '));

        int count = map.getOrDefault(ip, 0) + 1;
        map.put(ip, count);

        if (count > maxCount) {
            maxCount = count;
            maxIp = ip;
        }
    }

    return maxIp;
}
```

### ✅ Advantages
- O(n) time
- No sorting
- More efficient string parsing

---

## 💡 Alternative Approach (Using Streams Fully)

```java
public static String findTopIpUsingStreams(String[] lines) {
    return Arrays.stream(lines)
            .map(line -> line.split(" ")[0])
            .collect(Collectors.groupingBy(ip -> ip, Collectors.counting()))
            .entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(null);
}
```

---

## 🧪 Robust Test Cases

### 1. Basic Test
```java
String[] logs = {
    "10.0.0.1 - log1",
    "10.0.0.1 - log2",
    "10.0.0.2 - log3"
};
// Expected: 10.0.0.1
```

### 2. Single Entry
```java
String[] logs = {"192.168.1.1 - test"};
// Expected: 192.168.1.1
```

### 3. Tie Case
```java
String[] logs = {
    "1.1.1.1 - a",
    "2.2.2.2 - b"
};
// Expected: Either one (define behavior!)
```

### 4. Empty Input
```java
String[] logs = {};
// Expected: null
```

### 5. Null Input
```java
String[] logs = null;
// Expected: null
```

### 6. Large Input
```java
// 1M entries (performance test)
```

### 7. Malformed Logs
```java
String[] logs = {
    "",
    "invalid-log",
    "10.0.0.1"
};
// Should handle gracefully
```

---

## 🔍 Improvements You Can Add
- Validate log format before parsing
- Handle ties explicitly
- Use regex or index-based parsing
- Add unit tests (JUnit)

---

## 🧠 Summary
| Approach | Time | Space | Notes |
|--------|------|------|------|
| Sorting | O(n log n) | O(n) | Simple but inefficient |
| Optimal | O(n) | O(n) | Best approach |
| Streams | O(n) | O(n) | Clean but slightly heavier |

---

## 📌 Final Recommendation
Use the **single-pass optimal approach** in production.
Use **streams** for readability when performance is not critical.

