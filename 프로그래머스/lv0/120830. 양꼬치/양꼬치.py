def solution(n, k):
    serviceDrink = n // 10
    k -= serviceDrink
    return 12000 * n + 2000 * k