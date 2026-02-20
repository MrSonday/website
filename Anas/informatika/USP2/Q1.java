public class Q1{
    public static void main(String[] args) {

        int[] numbers = {1,2,3,4,5};
        System.out.println(atLeastOneOdd(numbers));
        System.out.println(allPositive(numbers));
        System.out.println(countEven(numbers));
        swapFirstLast(numbers);
        System.out.println(java.util.Arrays.toString(numbers));
        int[] reversed = reverseArray(numbers);
        System.out.println(java.util.Arrays.toString(reversed));
        int[] rotated = rotateRightN(numbers, 2);
        System.out.println(java.util.Arrays.toString(rotated));
        System.out.println(sumWithoutMinMax(numbers));
        System.out.println(averageScore(numbers));
        System.out.println(secondLargest(numbers));
        System.out.println(hasDuplicate(numbers));
        System.out.println(mostFrequentEven(numbers));
        System.out.println(isPalindromeArray(numbers));
        shiftZeroToEnd(new int[]{0,1,0,3,12});
        longestIncreasingSubarea(new int[]{1,2,2,3,4,1,5,6});

    }

    public static boolean atLeastOneOdd(int[] arr){
        for (int numbers : arr){
            if (numbers % 2 != 0){
                return true;
            }
        }
        return false;
    }


    public static boolean allPositive(int[] arr){
        for (int numbers : arr){
            if (numbers < 0){
                return false;
            }
        }
        return true;
    }


    public static int countEven(int[] arr){
        int count = 0;
        for (int numbers : arr){
            if (numbers % 2 == 0){
                count++;
            }
        }
        return count;
    }

    public static void swapFirstLast(int[] arr){
        int temp = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;
    }

    public static int[] reverseArray(int[] arr){
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    public static int[] rotateRightN (int[] arr, int n){
        int len = arr.length;
        int[] rotated = new int[len];
        for (int i = 0; i < len; i++){
            rotated[(i + n) % len] = arr[i];
        }
        return rotated;
    }

    public static int sumWithoutMinMax(int[] arr){
        if (arr.length <= 2){
            return 0;
        }
        int min = arr[0];
        int max = arr[0];
        int sum = 0;

        for (int numbers : arr){
            if (numbers < min){
                min = numbers;
            }
            if (numbers > max){
                max = numbers;
            }
            sum += numbers;
        }
        return sum - min - max;
    }

    public static double averageScore(int[] arr){
        if (arr.length == 0){
            return 0.0;
        }
        int sum = 0;
        for (int numbers : arr){
            sum += numbers;
        }
        return (double) sum / arr.length;
    }

    public static int secondLargest(int[] arr){
        if (arr.length < 2){
            throw new IllegalArgumentException("Array must have at least two elements");
        }
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int numbers : arr){
            if (numbers > first){
                second = first;
                first = numbers;
            } else if (numbers > second && numbers != first){
                second = numbers;
            }
        }
        if (second == Integer.MIN_VALUE){
            throw new IllegalArgumentException("No second largest element found");
        }
        return second;
    }

    public static boolean hasDuplicate(int[] arr){
        java.util.HashSet<Integer> seen = new java.util.HashSet<>();
        for (int numbers : arr){
            if (seen.contains(numbers)){
                return true;
            }
            seen.add(numbers);
        }
        return true;
    }

    public static long mostFrequentEven (int[] arr){
        java.util.HashMap<Integer, Integer> freqMap = new java.util.HashMap<>();
        for (int numbers : arr){
            if (numbers % 2 == 0){
                freqMap.put(numbers, freqMap.getOrDefault(numbers, 0) + 1);
            }
        }
        int maxFreq = 0;
        int mostFrequent = -1;
        for (java.util.Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            if (entry.getValue() > maxFreq || (entry.getValue() == maxFreq && entry.getKey() < mostFrequent)){
                maxFreq = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }
        return -1;
    }

    public static boolean isPalindromeArray(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while (left < right){
            if (arr[left] != arr[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void shiftZeroToEnd(int[] arr){
        int insertPos = 0;
        for (int num : arr){
            if (num != 0){
                arr[insertPos++] = num;
            }
        }
        while (insertPos < arr.length){
            arr[insertPos++] = 0;
        }
    }

    public static void longestIncreasingSubarea(int[] arr){
        if (arr.length == 0){
            System.out.println("Array is empty");
            return;
        }
        int maxLength = 1;
        int currentLength = 1;
        int startIndex = 0;
        int maxStartIndex = 0;

        for (int i = 1; i < arr.length; i++){
            if (arr[i] > arr[i - 1]){
                currentLength++;
            } else {
                if (currentLength > maxLength){
                    maxLength = currentLength;
                    maxStartIndex = startIndex;
                }
                currentLength = 1;
                startIndex = i;
            }
        }
        if (currentLength > maxLength){
            maxLength = currentLength;
            maxStartIndex = startIndex;
        }

        System.out.print("Longest Increasing Subarray: ");
        for (int i = maxStartIndex; i < maxStartIndex + maxLength; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}