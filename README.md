■ Tech
    - Java 17
    - STS4
    - docker
    - redis

■ Attribute
    - index     # 주문 ID
    - name      # 고객명
    - date      # 주문날짜
    - status    # 주문상태(0:처리중, 1:배송중, 2:완료)

■ 기능
외부 시스템에서 받아오는 데이터는 JSONObject or JSONArray상태
[
    {
        "index":"4525",
        "name":"용범중",
        "date":"2024-12-14",
        "status":"2"
    },
    {
        "index":"3394",
        "name":"범중",
        "date":"2024-12-15",
        "status":"2"
    }
]

■ 기본명령어
ㅁ Redis
    ● 동작
        redis-cli [--raw 한글 정상출력]
    ● Hash value 단일출력
        HGET {key} {field}
    ● Hash value 다중출력
        HMGET {key} [field ...]
    ● Hash value 전부출력
        HGETALL

ㅁ redisTemplate (java - redis)
    ● hash.entries  해당하는 Hash의 Map<String, Object> 출력
    ● hash.keys     해당하는 Hash의 keys 출력
    ● hash.values   해당하는 Hash의 Values 출력