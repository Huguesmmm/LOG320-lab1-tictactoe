
enum Mark{
        X,
        O,
        EMPTY;

        public boolean isEmpty(){
            return this == EMPTY;
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
                return EMPTY;
            }
        }
    }

    

