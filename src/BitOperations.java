public class BitOperations {
    /*
    There are 4 basic bit operations that we need to do:
    1. get bit
    2. set bit
    3. clean bit
    4. update bit - Change from 0 to and 1 to 0

    For bit operation in Java, there is a generic pattern for all operations that we follow:
    1. Take a help of extra variable  and set specific bit of this. Usually call this variable as bitMask
    2. Perform the right operation b/w the given number and bitMask
    3. Check the o/p received from Step2.
     */

    int number;
    int bitPosition;
    int bitMask;
    BitOperations(int number, int bitPosition) {
        this.number = number;
        this.bitPosition = bitPosition;
    }

    void getBit() {
        // operation required for getBit is AND
        this.bitMask = 1 << bitPosition;

        if ( (this.number & this.bitMask) > 0) {
            System.out.println("Bit " + bitPosition + " in number "+ number + " is set" );
        } else {
            System.out.println("Bit " + bitPosition + " in number "+ number + " is NOT set" );
        }
    }

    void setBit() {
        // operation required for setBit is OR
        int originalNum = this.number;
        this.bitMask = 1 << bitPosition;
        System.out.println("Given number is: " + originalNum);
        this.number = this.number | this.bitMask;

        if (originalNum == this.number) {
            System.out.println("Bit " + bitPosition + " in number "+ number + " was already set" );
        } else {
            System.out.println("Bit " + bitPosition + " in number "+ originalNum + " was NOT set" );
            System.out.println("Update number after setting Bit " + bitPosition + " in number "+ originalNum + " becomes " + this.number );
            this.number = originalNum;
            System.out.println("Resetting the number again to original number as " + originalNum );
        }
        this.number = originalNum;
    }

    void clearBit() {
        // operation required for updateBit is XOR of (number) and ( bitmask)
        int originalNum = this.number;
        this.bitMask = 1 << bitPosition;
        System.out.println("Given number is: " + originalNum);
        this.number = this.number & (~(this.bitMask));

        if (originalNum == this.number) {
            System.out.println("Bit " + bitPosition + " in number "+ number + " was already clear" );
        } else {
            System.out.println("Bit " + bitPosition + " in number "+ originalNum + " was NOT clear" );
            System.out.println("Update number after setting Bit " + bitPosition + " in number "+ originalNum + " becomes " + this.number );
            this.number = originalNum;
            System.out.println("Resetting the number again to original number as " + originalNum );
        }
        this.number = originalNum;
    }

    void updateBit() {
        // operation required for clearBit is AND of (number) and (not of bitmask)
        int originalNum = this.number;
        this.bitMask = 1 << bitPosition;
        System.out.println("Given number is: " + originalNum);
        this.number = this.number ^ this.bitMask;

        System.out.println("After  updating Bit at position " + bitPosition + " in number "+ originalNum + " becomes " + this.number );
        this.number = originalNum;
        System.out.println("Resetting the number again to original number as " + originalNum );
    }


}
