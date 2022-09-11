package com.wyh.demo.hope;

/**
 * @Classname LeetCode211
 * @Description TODO
 * @Date 2022/9/10 0:15
 * @Created by 61635
 * 添加与搜索单词
 */
public class WordDictionary {
    private WordDictionary[] items;
    private boolean isEnd;
    public WordDictionary(){
        items = new WordDictionary[26];
    }
    public void addWord(String word){
        WordDictionary curr = this;
        int len = word.length();
        for(int i = 0;i<len;i++){
            int index = word.charAt(i) - 'a';
            if(curr.items[index] == null){
                curr.items[index] = new WordDictionary();
            }
            curr = curr.items[index];
        }
        curr.isEnd = true;
    }

    public boolean search(String word){
        return search(this,word,0);
    }

    private boolean search(WordDictionary curr,String word,int start){
        int len = word.length();
        if(start == len){
            return curr.isEnd;
        }
        char c = word.charAt(start);
        if(c != '.'){
            int index = c - 'a';
            WordDictionary item = curr.items[index];
            return item!=null && search(item,word,start+1);
        }

        for(int j = 0;j<26;j++){
            if (curr.items[j] != null && search(curr.items[j], word, start + 1)) {
                return true;
            }
        }
        return false;
    }
}
