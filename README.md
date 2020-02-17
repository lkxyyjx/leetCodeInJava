# leetCodeInJava
- 是时候开始刷题了！

## dp问题一般思路与解法
- 【状态】与【选择】
   - dp问题一般需要抓住【状态】与【选择】，【状态】就是在确定的一组具体参数下能确定目标结果；【选择】就是一些具体的操作
   - 【选择】会导致【状态】的变化，也可以由此得出dp问题的状态转移方程
   - 找出状态转移方程后，再明确base condition（或者说是边界条件），这个时候dp问题如何解决一般就非常明晰了
- 实现细节
   - 可以基于【选择】去循环计算出每一个状态，也可以基于【状态参数】去循环计算出每一个状态
   - 递归实现时，需要避免重复的状态计算，避免多余的计算和减少调用栈，可以设置一个数组保存已经计算过的【状态】
## 回溯问题的一般思路与解法
- 找到问题的一般过程与边界条件，使用递归实现时先确定递归参数，注意留意过程中的对象变量
- 明确哪些操作是要递归前完成的，哪些操作是需要在递归后完成的
- 递归实现时，如果担心调用栈过长或者理不清递归逻辑，过程可以使用循环+stack替代实现