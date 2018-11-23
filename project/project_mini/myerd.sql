
/* Drop Tables */

DROP TABLE cosmetic CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE cosmetic
(
	product_name varchar2(50),
	cosmetic_id number,
	price number,
	age number,
	brand number,
	sex varchar2(10),
	skin_type varchar2(50),
	category varchar2(50)
);

INSERT INTO cosmetic
VALUES('LABOLABO SUPER KEANA LOTION 200ml',001,24000,10,1,'여성','건성','기초케어');
SELECT * FROM cosmetic
ORDER BY product_id 
SELECT * FROM cosmetic WHERE product_name LIKE ('%SUPER%');

ALTER TABLE cosmetic
ADD product_id number(4)
DROP TABLE cosmetic;

CREATE TABLE cosmetic
(
	product_id number(3),
	product_category varchar2(50),
	product_name varchar2(50),
	product_price number(7),
	user_age varchar2(50),
	brand_name varchar2(50),
	user_sex varchar2(50),
	user_type varchar2(50)
);


CREATE TABLE cosmetic
(
   product_id number(3),
   product_category varchar2(50),
   product_name varchar2(70),
   product_price number(7),
   user_age varchar2(50),
   brand_name varchar2(50),
   user_sex varchar2(50),
   user_type varchar2(50),
   image varchar2(100)
);

INSERT INTO cosmetic
VALUES(1,'전체,립제품','KATE CC립크립',9900 ,'전,10,20,30,40','가네보','공용','모든피부','src/project_mini/image/1.png');

INSERT INTO cosmetic
VALUES(2,'전체,립제품','게리쏭 에센셜 립밤 퓨어 ',4200 ,'전,10,20,30,40','게리쏭','여성','모든피부','src/project_mini/image/2.png');

INSERT INTO cosmetic
VALUES(3,'전체,립제품','겐조 밤 포 립스 투 키스 ',33000 ,'전,10,20,30,40','겐조','여성','모든피부','src/project_mini/image/3.png');

INSERT INTO cosmetic
VALUES(4,'전체,립제품','겔랑 키스키스 로스립 밤 ',40000 ,'전,10,20,30,40','겔랑','여성','모든피부','src/project_mini/image/4.png');

INSERT INTO cosmetic
VALUES(6,'전체,립제품','궁중비책 모이스쳐 스틱 밤',15000 ,'전,10,20,30,40','궁중비책','공용','모든피부','src/project_mini/image/6.png');

INSERT INTO cosmetic
VALUES(7,'전체,립제품','그린핑거 마이키즈 립밤', 7200,'전,10,20,30,40','그린핑거','공용','모든피부','src/project_mini/image/7.png');

INSERT INTO cosmetic
VALUES(8,'전체,립제품','플럼프레이져스 메탈릭 립플럼퍼 트리트먼스 ', 23000,'전,10,20,30,40','샤넬','여성','모든피부','src/project_mini/image/8.png');

INSERT INTO cosmetic
VALUES(9,'전체,립제품','니베아 립케어 모이스쳐 4.8g ', 10000,'전,10,20,30,40','니베아','공용','모든피부','src/project_mini/image/9.png');

INSERT INTO cosmetic
VALUES(10,'전체,립제품','키엘 레몬버터 컬러 립밤', 24000,'전,10,20,30,40','키엘','공용','모든피부','src/project_mini/image/10.png');

SELECT* from cosmetic;

INSERT INTO cosmetic
VALUES(11,'전체,립제품','입생로랑 베르니 아 레브르 팝 워터',41000,'전,10,20,30,40','입생로랑','여성','모든피부','src/project_mini/image/11.png');

INSERT INTO cosmetic
VALUES(12,'전체,립제품','헤라 루즈 홀릭 리퀴드 5g', 32000,'전,10,20,30,40','헤라','여성','모든피부','src/project_mini/image/12.png');

INSERT INTO cosmetic
VALUES(13,'전체,립제품','설화수 에센셜 립세럼 스틱 3g ',40000 ,'전,10,20,30,40','설화수','여성','모든피부','src/project_mini/image/13.png');

INSERT INTO cosmetic
VALUES(14,'전체,립제품','더 후 공진향미 럭셔리 립루즈 6g ', 28000,'전,10,20,30,40','후','여성','모든피부','src/project_mini/image/14.png');

INSERT INTO cosmetic
VALUES(15,'전체,립제품','시세이도 베네피앙스 풀 코릭션 립 트리트먼트 ',31000 ,'전,10,20,30,40','시세이도','공용','모든피부','src/project_mini/image/15.png');

INSERT INTO cosmetic
VALUES(16,'전체,립제품','베네피트 데아 리얼 더블 더립 1.5g ',18000 ,'전,10,20,30,40','베네피트','여성','모든피부','src/project_mini/image/16.png');

INSERT INTO cosmetic
VALUES(17,'전체,립제품','샤넬 루쥬 알뤼크 잉크 6ml ',45000 ,'전,10,20,30,40','샤넬','여성','모든피부','src/project_mini/image/17.png');

INSERT INTO cosmetic
VALUES(18,'전체,립제품','랑콤 마뜨 쉐이커',37000 ,'전,10,20,30,40','랑콤','여성','모든피부','src/project_mini/image/18.png');

INSERT INTO cosmetic
VALUES(19,'전체,립제품','디올 어딕트 립 글로우 3,5g ',30000 ,'전,10,20,30,40','디올','여성','모든피부','src/project_mini/image/19.png');

INSERT INTO cosmetic
VALUES(20,'전체,립제품','에스케이투 링클 스페셜리스트 25g ', 20000,'전,10,20,30,40','에스케이투','공용','모든피부','src/project_mini/image/20.png');

SELECT* from cosmetic;

INSERT INTO cosmetic
VALUES(21, '전체,스킨', 'IMPRESS EMULSION 2 100ml', 104000, '전,10,20,30,40','가네보', '여성', '건성','src/project_mini/image/21.png');

INSERT INTO cosmetic
VALUES(22, '전체,스킨', 'GUERISSON SKIN 130ml', 14000, '20,30,40', '게리쏭', '공용', '건성,지성','src/project_mini/image/22.png');

INSERT INTO cosmetic
VALUES(23, '전체,스킨', 'KENZOKI SKIN MOISTURIZING SKIN GUARDIAN', 43000, '20,30', '겐조', '공용','건성','src/project_mini/image/23.png');  

INSERT INTO cosmetic
VALUES(24, '전체,스킨', 'ORCHIDEE IMPERIALE TONER 125ml', 136000, '30,40', '겔랑', '여성', '지성','src/project_mini/image/24.png');   

INSERT INTO cosmetic
VALUES(25, '전체,스킨', 'GO WHITHME MVP all-in-one facial treatment 80ml', 11000, '10,20', '고위드미', '공용', '지성,건성','src/project_mini/image/25.png'); 

INSERT INTO cosmetic
VALUES(26, '전체,스킨', 'Going Secret sodding fluid 160ml', 19000, '10', '궁중비책', '여성', '지성,건성','src/project_mini/image/26.png');    

INSERT INTO cosmetic
VALUES(27, '전체,스킨', 'GREEN FINGER ULTRA SKIN 300ml', 15000, '10', '그린핑거', '여성', '건성','src/project_mini/image/27.png');       

INSERT INTO cosmetic
VALUES(29, '전체,스킨', 'NIVEA FOR MAN COOLKICK AFTER SHAVE SKIN 100ml', 5000, '10', '니베아', '남성', '건성,지성','src/project_mini/image/29.png');   

INSERT INTO cosmetic
VALUES(30, '전체,스킨', 'KIEHLs CALENDULA HERVAL-EXTRA TONER 500ml', 104000, '20,30', '키엘 ', '여성', '지성','src/project_mini/image/30.png');  

SELECT* from cosmetic;

INSERT INTO cosmetic
VALUES(31, '전체,스킨', 'yves saint laurent 3-in-1 toning and clea 150ml', 66000, '20,30,40', '입생로랑', '여성', '건성','src/project_mini/image/31.png');  

INSERT INTO cosmetic
VALUES(32, '전체,스킨', 'HERA SIGNIA WATER 180ml', 56000, '20,30,40', '헤라', '여성', '지성','src/project_mini/image/32.png');        

INSERT INTO cosmetic
VALUES(33, '전체,스킨', 'SULWHASOO VITALIZING WATER 150ml', 75000, '전,10,20,30,40', '설화수', '여성', '지성,건성','src/project_mini/image/33.png');    

INSERT INTO cosmetic
VALUES(34, '전체,스킨', 'REFRESHING TONER 300ml', 33000, '30,40', '후 ', '여성', '지성','src/project_mini/image/34.png');        

INSERT INTO cosmetic
VALUES(35, '전체,스킨', 'SHISEIDO WHITE LUSENTE INFUSER 150ml', 55000, '30,40', '시세이도', '여성', '건성','src/project_mini/image/35.png');       

INSERT INTO cosmetic
VALUES(37, '전체,스킨', 'CHANEL LOTION DOUCEUR GENTLE TONER 200ml', 61000, '20,30,40', '샤넬', '여성', '지성','src/project_mini/image/37.png');        

INSERT INTO cosmetic
VALUES(38, '전체,스킨', 'LANCOME TONIQUE CONFORT TONER 400ml', 54000, '20,30', '랑콤', '여성', '건성,지성','src/project_mini/image/38.png');     

INSERT INTO cosmetic
VALUES(39, '전체,스킨', 'DITOR CAPTURE TOTALE DREAMSKIN SKIN 150ml', 105000, '20,30,40', '디올', '여성', '지성','src/project_mini/image/39.png');   

INSERT INTO cosmetic
VALUES(40, '전체,스킨', 'Facial Treatment Clear Lotion Toner 150ml', 119000, '30,40', '에스케이투', '여성', '건성,지성','src/project_mini/image/40.png'); 

SELECT* from cosmetic;

INSERT INTO cosmetic
VALUES(41,'전체,클랜징', '탑 시크릿 내추럴 액션 엑스폴리에이터', 52000, '20,30', '입생로랑', '공용', '복합성','src/project_mini/image/41.png');

INSERT INTO cosmetic
VALUES(42,'전체,클랜징', '스킨 릴리프 클렌징 폼', 12000, '30,40', '게리쏭9컴플렉스', '공용', '건성','src/project_mini/image/42.png');

INSERT INTO cosmetic
VALUES(43,'전체,클렌징', '뷰티 클리어 파우더', 30000, '전,10,20,30,40', '수이사이', '여성', '건성','src/project_mini/image/43.png');

INSERT INTO cosmetic
VALUES(44,'전체,클렌징', '블랑 드 펄 클렌징 폼', 78000, '30,40', '겔랑', '공용', '건성','src/project_mini/image/44.png');

INSERT INTO cosmetic
VALUES(45,'전체,클렌징', '리프레싱 미셀라 솔루션 퓨어 래디언스 클렌저', 79000, '30,40', '겔랑', '공용', '건성','src/project_mini/image/45.png');

INSERT INTO cosmetic
VALUES(46,'전체,클렌징', '마일드 클랜징 티슈', 3000, '10', '궁중비책', '공용', '모든피부','src/project_mini/image/46.png');

INSERT INTO cosmetic
VALUES(47,'전체,클렌징', '촉촉한 자연보습 퓨어 클렌징 워터', 17000, '10', '그린핑거', '공용', '건성, 민감성','src/project_mini/image/47.png');

INSERT INTO cosmetic
VALUES(48,'전체,클렌징', '써스티클렌즈 데일리 하이드레이팅 클렌져', 49000, '전,10,20, 30, 40', '글램글로우', '공용', '복합성, 여드름성','src/project_mini/image/48.png');

INSERT INTO cosmetic
VALUES(49,'전체,클렌징', '센서티브 3 in 1 미셀라 클렌징 워터', 21000, '전,10,20, 30, 40', '니베아', '공용', '건성, 아토피성','src/project_mini/image/49.png');

INSERT INTO cosmetic
VALUES(50,'전체,클렌징', '칼렌둘라 딥 클렌징 포밍 페이스 워시', 39000, '전,10,20, 30, 40', '키엘', '공용', '건성','src/project_mini/image/50.png');

SELECT* from cosmetic;

INSERT INTO cosmetic
VALUES(51,'전체,클렌징', '레어 어스 딥 포어 데일리 클렌저', 31000, '전,10,20, 30, 40', '키엘', '공용', '복합성, 여드름성','src/project_mini/image/51.png');

INSERT INTO cosmetic
VALUES(52,'전체,클렌징', '퓨어 클렌징 리무버', 12000,  '20,30,40', '헤라', '공용', '건성','src/project_mini/image/52.png');

INSERT INTO cosmetic
VALUES(53,'전체,클렌징', '화이트 프로그램 딥 클렌징 폼', 32000, '20,30,40', '헤라', '공용', '지성','src/project_mini/image/53.png');

INSERT INTO cosmetic
VALUES(54,'전체,클렌징', '순행 클렌징 오일', 40000, '20,30,40', '설화수', '공용', '건성, 아토피성','src/project_mini/image/54.png');

INSERT INTO cosmetic
VALUES(55,'전체,클렌징', '티스 딥 오프 오일', 18000, '20,30,40', '시세이도', '공용', '지성','src/project_mini/image/55.png');

INSERT INTO cosmetic
VALUES(56,'전체,클렌징', '데아 리얼 리무버', 28000, '전,10,20, 30, 40', '베네피트', '남성', '건성','src/project_mini/image/56.png');

INSERT INTO cosmetic
VALUES(57,'전체,클렌징', '수블리마지 데마끼앙 꽁포르 수프렘', 45000, '20,30,40', '샤넬', '여성', '건성, 여드름성','src/project_mini/image/57.png');

INSERT INTO cosmetic
VALUES(58,'전체,클렌징', '무쓰 에끌라 포밍 클렌저', 30000, '전,10,20, 30, 40', '랑콤', '공용', '복합성, 여드름성','src/project_mini/image/58.png');

INSERT INTO cosmetic
VALUES(59,'전체,클렌징', '인스턴트 아이 메이크업 리무버', 40000, '20,30,40', '디올', '여성', '복합성','src/project_mini/image/59.png');

INSERT INTO cosmetic
VALUES(60,'전체,클렌징', '페이셜 트리트먼트 클렌징 오일', 76000, '20,30,40', '에스케이투', '공용', '복합성, 여드름성','src/project_mini/image/60.png');

SELECT* from cosmetic;

INSERT INTO cosmetic
VALUES(61,'전체,로션','AGE AWAY VITALIZING EMULSION',55000,'전,10,20,30,40','헤라','여성','건성','src/project_mini/image/61.png');

INSERT INTO cosmetic
VALUES(62,'전체,로션','자음유액',6300,'30,40','설화수','여성','복합성','src/project_mini/image/62.png');

INSERT INTO cosmetic
VALUES(63,'전체,로션','BLUE ASTRINGENT HERBAL LOTION',29000,'전,10,20,30,40','키엘','여성','지성,여드름성','src/project_mini/image/63.png');

INSERT INTO cosmetic
VALUES(64, '전체,로션','HYDRA BEAUTY LOTION',74000,'전,10,20,30,40','샤넬','여성','건성','src/project_mini/image/64.png');

INSERT INTO cosmetic
VALUES(65, '전체,로션','FACIAL LIFT EMULSION',125000,'전,10,20,30,40','에스케이투','여성','지성','src/project_mini/image/65.png');

INSERT INTO cosmetic
VALUES(66,'전체,로션','BLANC DE PERLE ESSENCE IN LOTION',89000,'전,10,20,30,40','겔랑','여성','복합성','src/project_mini/image/66.png');

INSERT INTO cosmetic
VALUES(67,'전체,로션','WHITE LUSCENT LUMINISING ',72000,'전,10,20,30,40','시세이도','여성','건성','src/project_mini/image/67.png');

INSERT INTO cosmetic
VALUES(68,'전체,로션','TRIPLE PERFORMING EMULSION',42000,'20,30','베네피트','여성','건성','src/project_mini/image/68.png');

INSERT INTO cosmetic
VALUES(69,'전체,로션','MY KIDS LOTION FRESH',23000,'10','그린핑거','공용','건성','src/project_mini/image/69.png');

INSERT INTO cosmetic
VALUES(70,'전체,로션','AQUA BOLIC ESSENCIAL EMULSION',46000,'전,10,20,30,40','헤라','여성','건성','src/project_mini/image/70.png');

SELECT* from cosmetic;

INSERT INTO cosmetic
VALUES(71,'전체,로션','공진향 수연 로션',79000,'30,40','후','여성','건성','src/project_mini/image/71.png');

INSERT INTO cosmetic
VALUES(72,'전체,로션','ENERGIE DE VIE PERLEE LOTION',63000,'전,10,20,30,40','랑콤','여성','건성','src/project_mini/image/72.png');

INSERT INTO cosmetic
VALUES(73,'전체,로션','WHITE PROGRAM RADIANCE EMULSION',50000,'전,10,20,30,40','헤라','공용','복합성','src/project_mini/image731.png');

INSERT INTO cosmetic
VALUES(74,'전체,로션','ULTRA FACIAL MOISTURIZER',40000,'전,10,20,30,40','키엘','공용','건성','src/project_mini/image/74.png');

INSERT INTO cosmetic
VALUES(75,'전체,로션','CAPTURE TOTALE CONSENTRATED NURTURING RICH LOTION',60000,'디올','전,10,20,30,40','공용','건성','src/project_mini/image/75.png');

INSERT INTO cosmetic
VALUES(76,'전체,로션','진설유액',120000,'30,40','설화수','여성','복합성','src/project_mini/image/76.png');

INSERT INTO cosmetic
VALUES(77,'전체,로션','자음생유액',90000,'30,40','설화수','여성','건성','src/project_mini/image/77.png');

INSERT INTO cosmetic
VALUES(78,'전체,로션','CELLUMINATION MASK IN LOTION',104000,'전,10,20,30,40','에스케이투','여성','건성','src/project_mini/image/78.png');

INSERT INTO cosmetic
VALUES(79,'전체,로션','WHITENING SOURCE CLEAR LOTION',80000,'전,10,20,30,40','에스케이투','여성','복합성','src/project_mini/image/79.png');

INSERT INTO cosmetic
VALUES(80,'전체,로션','IBUKI PROTECTED MOISTURIZER',70000,'전,10,20,30,40','시세이도','여성','복합성','src/project_mini/image/80.png');

SELECT* from cosmetic;

INSERT INTO cosmetic
VALUES(81,'전체,선케어','ALLIE SPF50+ PA+++ SUNSCREEN 60ml',27000 ,'30','가네보','여성','복합성','src/project_mini/image/81.png');

INSERT INTO cosmetic
VALUES(82,'전체,선케어','게리쏭 멀티얼반프로텍터', 26000,'20,30','게리쏭','여성','건성,복합성','src/project_mini/image/82.png');

INSERT INTO cosmetic
VALUES(83,'전체,선케어','KENZOKI SKIN TOPCOAT SPF30 PA+++ 50ml', 37000,'30','겐조','공용','복합성','src/project_mini/image/83.png');

INSERT INTO cosmetic
VALUES(84,'전체,전체,선케어','BLANC DE PERLE UV BASE DUO SET 30ml', 120000,'20,30,40','겔랑','여성','지성','src/project_mini/image/84.png');

INSERT INTO cosmetic
VALUES(85,'전체,선케어','고위드미 프로 내츄럴 선스틱 ', 10000,'10,20','고위드미','여성','복합성','src/project_mini/image/85.png');

INSERT INTO cosmetic
VALUES(86,'전체,선케어','궁중비책 플레이 선로션 SPF50 PA++',16000 ,'전,10,20,30,40','궁중비책','공용','복합성','src/project_mini/image/86.png');

INSERT INTO cosmetic
VALUES(87,'전체,선케어','그린핑거 훼이셜선 40ml',14000 ,'10,20','그린핑거','남성,여성','복합성','src/project_mini/image/87.png');

INSERT INTO cosmetic
VALUES(88,'전체,선케어','글로우스타터 모이스쳐라이저 펄 글로우',36000 ,'20,30','글램글로우','여성','건성','src/project_mini/image/88.png');

INSERT INTO cosmetic
VALUES(89,'전체,선케어','니베아 페이스 선블럭 화이트닝 크림 50ml(SPF50)',7000 ,'10,20','니베아','공용','건성','src/project_mini/image/89.png');

INSERT INTO cosmetic
VALUES(90,'전체,선케어','울트라 라이트 데일리 유브이 디팬스 썬스크린',42000 ,'20,30,40','키엘','공용','복합성','src/project_mini/image/90.png');

SELECT* from cosmetic;

INSERT INTO cosmetic
VALUES(91,'전체,선케어','뚜쉬 에끌라 블러 선프라이머 30ml', 60000,'20,30','입생로랑','여성','지성','src/project_mini/image/91.png');

INSERT INTO cosmetic
VALUES(92,'전체,선케어','헤라 선 메이트 레포츠 SPF50+ PA++++', 27000,'20,30,40','헤라','여성','건성','src/project_mini/image/92.png');

INSERT INTO cosmetic
VALUES(93,'전체,선케어','AP 트리플디펜스선프로텍터 SPF50+ PA+++ 60ml',70000 ,'30,40','설화수','여성','건성','src/project_mini/image/93.png');

INSERT INTO cosmetic
VALUES(94,'전체,선케어','후 공진향 진해윤 링클 선 17년 G 50ml',50000 ,'30,40','후','여성','복합성','src/project_mini/image/94.png');

INSERT INTO cosmetic
VALUES(95,'전체,선케어','PERFECT UV SUNSCREEN SKINCARE MILK SPF50+ PA++++',35000 ,'20,30','시세이도','공용','복합성','src/project_mini/image/95.png');

INSERT INTO cosmetic
VALUES(96,'전체,선케어','Dream Screen 45ml',36000 ,'20,30','베네피트','여성','건성','src/project_mini/image/96.png');

INSERT INTO cosmetic
VALUES(97,'전체,선케어','씨씨 크림 코렉션 컴플리트 수퍼 액티브 30ml', 60000,'20,30,40','샤넬','여성','건성','src/project_mini/image/97.png');

INSERT INTO cosmetic
VALUES(98,'전체,선케어','UV 엑스퍼트 유스 쉴드 아쿠아 젤 50ml',65000 ,'20,30,40','랑콤','공용','복합성','src/project_mini/image/98.png');

INSERT INTO cosmetic
VALUES(99,'전체,선케어','DIOR PRESTIGE WHITE COLLECTION UV BLEMISH BALM 30ML',110000 ,'20,30','디올','여성','복합성','src/project_mini/image/99.png');

INSERT INTO cosmetic
VALUES(100,'전체,선케어','애트모스피어 에리 라이트 유브이 에멀젼 30g',60000 ,'30,40','에스케이투','여성','건성','src/project_mini/image/100.png');

SELECT* from cosmetic;






 ALTER TABLE cosmetic
 modify product_category varchar2(1000);
 
 UPDATE COSMETIC
 set  user_age = '전,10,20,30,40'
 where product_id = 8 ;
 
 DROP table cosmetic
 where user_age is null;
 
INSERT INTO cosmetic
 where user_sex like '%여성%'and ( product_category like '%스킨%' ) and (user_age like '%20대%' and (brand_name = '샤넬' or brand_name = '랑콤')
         41 '전체,클렌징'           탑 시크릿 내추럴 액션 엑스폴리에이터                                        52000 20, 30           입생로랑(YVESSAINTLAURENT)      공용       복합성

select * from cosmetic
 where user_sex like '%여성%'and ( product_category like '%로션%' ) and (user_age like '%20대%' ) and (brand_name = '샤넬') and ( user_type like '%지성%')
ORDER BY product_id
select*from cosmetic
 where user_sex like '%여성%'and ( product_category like '%스킨%')
select*from cosmetic
 where user_sex like '%여성%'and (product_category like '%로션%') and brand_name = '샤넬' 
 where user_sex like '%여성%'and (product_category like '%로션%'or product_category like '%선케어%') and (user_age like '%20대%' )and product_price >=30000원 ~ and (brand_name = '샤넬'
 select product_name, product_price,brand_name
from cosmetic
where product_category like '%스킨%'
         41 전체,클렌징           탑 시크릿 내추럴 액션 엑스폴리에이터                                        52000 20, 30           입생로랑(YVESSAINTLAURENT)      공용       복합성

스킨 '스킨,A,ab,ac,ad,ae,a/b/c,a/b/d,a/b/e,a/c/d,a/c/e,a/d/e,a//b//c//d,a//b//c//e,a//b//d//e,a//c//d//e'
로션 '로션,B,ab,bc,bd,be,a/b/c,a/b/d,a/b/e,b/c/d,b/c/e,b/d/e,a//b//c//d,a//b//c//e,a//b//d//e,b//c//d//e'
선케어'선케어,C,ac,bc,cd,ce,a/b/c,a/c/d,a/c/e,b/c/d,b/c/e,c/d/e,a//b//c//d,a//b//c//e,a//c//d//e,b//c//d//e'
클랜징'클렌징,D,ad,bd,cd,de,a/b/d,a/c/d,a/d/e,b/c/d,b/c/d,c/d/e,a//b//c//d,a//b//d//e,a//c//d//e,b//c//d//e'
립케어'전체,립케어,E,ae,be,ce,de,a/b/e,a/c/e,a/d/e,b/c/e,b/d/e,c/d/e,a//b//c//e,a//b//d//e,a//c//d//e,b//c//d//e'
select*from cosmetic 
where user_sex = '여성' and user_type like ( '%모든피부%' )
 where user_sex like ( '%여성%'
10 '전체,10,ab,ac,ad,'
20 where user_sex like ('%여성%'and ( product_category like '%선케어%' ) and (user_age like '%30%' ) and product_price >=30000원 ~ ) and (brand_name = '샤넬'
30model.setRowCount(0);
40model.setRowCount(0);
 where user_sex like '%여성%' ) and (user_age like '%20%'
model.setRowCount(0);
  where user_sex like ( '%여성%' ) and product_price >=5000
  where user_sex like ( '%여성%' ) and (brand_name = '키엘'
  where user_sex like ( '%여성%' ) and ( product_price >=50000 ) and ( product_price >=60000
 5000
 '시세이도' where user_sex like ( '%여성%'
  where user_sex like ( '%여성%' ) and (brand_name = '시세이도'
  where user_sex like ( '%여성%'and ( product_category like '%로션%' ) and (user_age like '%20%' ) and ( product_price >=30000
 
 y like '%로션%' ) and (user_age like '%20%' ) and ( product_price >=30000
 
 select * from cosmetic
  where (brand_name =)
 
 
 
 
 CREATE TABLE buy(
name varchar2(20),
address varchar2(50),
product_id number(10),
count number(10)
);

CREATE TABLE client(
id varchar2(20),
password varchar2(20),
name varchar2(20),
address varchar2(50),
point number(10),
grade varchar(20)
);

SELECT * FROM buy;

SELECT * FROM client;

DROP TABLE client;

DELETE FROM client;

DROP TABLE buy;

DELETE FROM buy;