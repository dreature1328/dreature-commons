import json
import random

def generate_random_str(randomlength=16):
    # randomlength 是生成值的长度
    # 将字符集定义为常量
    base_str = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789'
    return ''.join(random.choices(base_str, k=randomlength))

def generate_mock_json(id):
    # str.zfill() 将数字前面填充 0 直到达到指定长度
    return {
        "id": str(id).zfill(6),
        "key1": generate_random_str(),
        "key2": generate_random_str()
    }

# 利用 json.dump() 函数将生成的数据直接写入文件
data = {"code": "200", "msg": "success", "data": [generate_mock_json(i+1) for i in range(500)]}

with open('mock_data.json', 'w', encoding='utf-8') as f:
    json.dump(data, f, ensure_ascii=False, indent=4)