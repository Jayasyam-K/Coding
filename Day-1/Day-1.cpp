/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.*/
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target)
     {
        for(int j=0;j<nums.size();j++){
            for(int k=j+1;k<nums.size();k++){
                if(nums[j]+nums[k]==target){
                    return{j,k};
                }

            }
        }
        return{-1,-1};
    }
    
};

//https://leetcode.com/problems/two-sum/
