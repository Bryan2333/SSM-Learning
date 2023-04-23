# limit语法： limit startIndex, count
SELECT *
FROM emp;

# limit可以实现分页查询
# 当前页码currentPage
# 页面大小pageSize 通常有前端定好
# limit (currentPage - 1) * pageSize, pageSize

# 第一页
SELECT *
FROM emp
LIMIT 0, 5;

# 第二页
SELECT *
FROM emp
LIMIT 5, 5;

# 第六页
SELECT *
FROM emp
LIMIT 25, 5;