Chương trình giải quyết bài toán producer & consumer:
- Có một message queue chứa các message, cấu trúc message là tùy chọn. Message queue có size giới hạn.
- Producer định kỳ tạo ra 1 message và đưa vào message queue. Nếu msgq full, đợi đến khi có thể add được vào queue.
- Consumer định kỳ lấy message từ message queue và in ra màn hình. Nếu msgq rỗng, dợi đến khi có message trong queue thì xử lý.

Usage: mvn exec:java -Dexec.args="<max size of queue> <time push msg> <time pull msg>"
Defaut: max size = 10, time push = 1, time pull = 3