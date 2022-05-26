create table porderdetail(
   orderdetailno int primary key auto_increment ,    /* 주문상세 번호 */
    orderdetailactive  int ,   /* 주문상세 상태 */
   sno int ,             /* 재고번호 */
    samount int ,          /* 수량 */ 
    totalprice   int ,       /* 총결제액 */
   orderno int ,           /* 주문번호 */ 
    foreign key( sno ) references stock( sno ) on update cascade , 
    foreign key( orderno ) references porder( orderno) on update cascade 
);
create table cart(
   cartno int primary key auto_increment ,    /* 카트 번호 */
    scolor varchar(100) , /* 색상 */
    sno int ,             /* 재고번호 */
    totalprice   int ,       /* 총결제액 */
    pno int ,            /* 제품번호 */
   mno int ,             /* 회원번호 */ 
    foreign key( sno ) references stock( sno ) on update cascade , 
    foreign key ( mno ) references member(mno) on update cascade 
);
create table porder(
   orderno    int primary key auto_increment ,    /* 주문 번호 */
    orderdate datetime default now() , /* 주문 날짜 */
    ordername varchar(20) , /* 받는사람 성명 */
    orderphone varchar(20) , /* 받는사람 연락처 */ 
    orderaddress varchar(100) , /* 받는사람 주소 */
    ordertotalpay int ,   /* 주문 총 결제액  */
    orderactive int ,   /* 주문 상태 */
    orderrequest varchar(100) ,   /* 주문 요청사항 */
    orderdeliverno int ,   /* 배송 번호  */
    mno int ,             /* 회원번호 */ 
    foreign key ( mno ) references member(mno) on update cascade 
);
