# 第三周学习笔记
## 递归
通过函数体来进行的循环   
通过参数进行传递变量
Python递归模板：      
```
def recursion(level, param1, param2, ...):
    #recursion terminator
	if level > MAX_LEVEL:
	process_result
	return
	
	#process logic current level
	process(level, data...)
	
	#drill down
	self.recursion(level + 1, p1, ...)
	
	#reverse the current level status if needed
```
Java递归模板：   
```
public void recursion(int level, int param) {
	
	//terminator
	if (level > MAX_LEVEL) {
		//process result
		return;
	}
	
	//process current logic
	process(level, param);
	
	//drill down
	recursion(level + 1, newParam);
	
	//restore current status
}
```
思维要点：   
1.不要人肉进行递归（最大误区）   
2.找到最近最简方法，将其拆解成可重复解决的子问题（重复子问题）   
3.数学归纳法的思维（多米诺骨牌）   

## 分治法
将原问题划分成相同解决方法的子问题，各个击破，最后合并结果。   
模板：   
```
def divide_conquer(problem, param1, param2, ...):
    # recursion terminator 
	if problem is None:
      print_result 
	  return
    
	# prepare data
    data = prepare_data(problem)
    subproblems = split_problem(problem, data) 
	
	# conquer subproblems
    subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
	subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
	subresult3 = self.divide_conquer(subproblems[2], p1, ...)
	...
    
	# process and generate the final result
    result = process_result(subresult1, subresult2, subresult3, …)

    # revert the current level states
```

## 回溯法
回溯法采用试错的思想，它尝试分步的去解决一个问题。   
回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况：   
	• 找到一个可能存在的正确的答案；   
	• 在尝试了所有可能的分步方法后宣告该问题没有答案。   
在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。   






























