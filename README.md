# TeachMeSkills: lesson 24

## Homework for lesson #24

### **Task #1: annotation & xml**

Application provides current date and time for next cities: Minsk, Washington, Beijing.   

2 options are possible:
- get date and time by next endpoints `/annotation/beijing`, `/annotation/minsk`, `/annotation/washington` via  
servlets with annotations.
- get date and time by next endpoints `/xml/beijing`, `/xml/minsk`, `/xml/washington` via servlets with annotations.

### **Task #1: path parameter**

Application provides current date and time for next cities: Minsk, Washington, Beijing.   

Task is implemented via path parameter `/time/*`. Next options are possible: `beijing`, `minsk`, `washington`.

---

### **Task #2: assert user age**

Application allows assert user age. 

2 options are possible:
- make GET request witn next endpoint `/checkAge` with query parameter `age`.
- make POST request witn next endpoint `/checkAge` and user `age` in request body.

---