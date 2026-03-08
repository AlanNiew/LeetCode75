# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## 项目概述

这是一个 Java 算法练习项目，专注于 LeetCode 精选 75 题的解决方案。项目按照算法类型和数据结构进行分类组织，旨在通过系统化的练习提升算法能力。

## 项目结构

### 主要包结构

- **基础数据结构**
  - `src/arrAndString` - 数组和字符串操作
  - `src/tree` - 二叉树、Trie树等树结构
  - `src/linkList` - 链表相关算法
  - `src/stack` - 栈结构应用
  - `src/queue` - 队列应用
  - `src/hash` - 哈希表算法

- **算法思想**
  - `src/backtrack` - 回溯算法
  - `src/binarySearch` - 二分查找及其变体
  - `src/doublePointer` - 双指针技巧
  - `src/dp` - 动态规划
  - `src/slidWindow` - 滑动窗口
  - `src/prefix` - 前缀和算法

- **高级主题**
  - `src/graph` - 图算法
  - `src/optimalpath` - 最优路径算法（含八数码问题A*实现）
  - `src/path` - 路径相关算法

- **特殊分类**
  - `src/oneQuestionPerDay` - 每日一题练习
  - `src/competition` - LeetCode 周赛和双周赛题目
  - `src/problems` - 通用问题集合

## 代码规范

每个类都遵循以下模式：

1. **包声明**：按功能分类在对应包下
2. **注释规范**：
   - 类和方法都有详细的中文注释
   - 包含时间复杂度和空间复杂度分析
   - 标注题目来源（LeetCode 编号）
3. **测试方式**：
   - 每个类都包含 main 方法，用于直接运行测试
   - 测试用例在 main 方法中直接编写和验证

## 开发工作流

### 运行单个算法
```bash
# 编译指定类
javac src/包名/类名.java

# 运行类（需要先设置类路径）
java -cp src 包名.类名
```

### 在 IDE 中运行
1. 使用 IntelliJ IDEA 打开项目
2. 直接右键点击 Java 文件，选择 "Run"
3. 或者在 main 方法中点击运行按钮

### 添加新题目
1. 根据题目类型选择对应的包
2. 创建新类，遵循命名规范（Problem01, Problem02... 或 Lt_XXX）
3. 实现解决方案，包含完整的测试用例
4. 添加详细的中文注释

## 特殊说明

- **项目配置**：纯 Java 项目，无 Maven 或 Gradle 依赖，使用 IDE 内置编译器
- **类路径设置**：运行时需要将 src 目录设置为类路径
- **编码风格**：
  - 使用中文注释
  - 方法命名采用驼峰命名法
  - 类名采用大驼峰命名法
  - 包名采用小写字母
- **测试验证**：通过控制台输出验证结果，每个算法都包含多个测试用例

## 八数码问题求解器

项目包含一个完整的八数码问题A*算法实现（`src/optimalpath/EightPuzzleSolver.java`）：
- 使用曼哈顿距离作为启发函数
- 支持可解性判断
- 输出详细的解题步骤

## 注意事项

- 这是一个学习项目，专注于算法实现而非企业级应用
- 代码中的时间复杂度和空间复杂度分析基于算法理论，实际运行可能受 JVM 影响而有所差异
- 部分题目可能有多种解法，当前实现通常是较为直观或高效的方案