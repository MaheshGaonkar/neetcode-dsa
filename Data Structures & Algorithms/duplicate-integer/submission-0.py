class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        seenNum = set()

        for num in nums:
            if num in seenNum:
                return True
            seenNum.add(num)

        return False

"""
1,2,3,3,4,4,5 - True
1,2,3,4 -> False
1,1,2,3,4 -> True
"""