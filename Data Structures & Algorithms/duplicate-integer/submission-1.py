class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        return len(set(nums)) != len(nums)

"""
1,2,3,3,4,4,5 - True
1,2,3,4 -> False
1,1,2,3,4 -> True
"""