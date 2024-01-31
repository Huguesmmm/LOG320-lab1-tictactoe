
public enum Mark{
        X,
        O,
        E;

        public boolean isEmpty(){
            return this == E;
        }

        public boolean isX(){
            return this == X;
        }

        public boolean isO(){
            return this == O;
        }

        public Mark opposite(){
            if (this == X){
                return O;
            } else if (this == O){
                return X;
            } else {
                return E;
            }
        }

        public static int isWinning() {
            return 100;
        }

        public static int isLosing() {
            return -100;
        }

        public static int isDraw() {
            return 0;
        }
    }

    

