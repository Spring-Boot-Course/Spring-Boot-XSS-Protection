# Spring-Boot-XSS-Protection

### Thymeleaf - Using Unescaped Text

기본적으로 Thymeleaf는 escaping 기능 제공. 따라서, XSS Protection 적용을 위해 Unescaped Text를 사용해야 한다.
https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#unescaped-text

```html
<p th:utext="#{home.welcome}">Welcome to our grocery store!</p>
``` 

```html
<p>Welcome to our <b>fantastic</b> grocery store!</p>
```


---

### 기본 프로젝트 환경 셋팅

https://jojoldu.tistory.com/255?category=635883
