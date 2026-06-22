### 자주쓰는 깃 명령어
- git status
- git add .
- git commit -m ""
- git push
- git pull

### Git remote -v
- 연동된 깃허브 주소. 즉 현재 연결된 원격 저장소 목록 확인.
- Origin 은 내가 설정한 GitHub 저장소 별명
- origin  https://github.com/Shye030n/java-algorithm-project.git (fetch)
- origin  https://github.com/Shye030n/java-algorithm-project.git (push)
- (fetch) = 가져오는 url(pull)
- (push) = 올리는 url (push)
---
### main vs master
- 브랜치 명
- 요즘은 대부분 main, 예전에는 대부분 master 사용.
- origin은 저장소, main은 브랜치
- git push origin main 이란, 내 컴퓨터 코드를 origin(github)의 main 브랜치로 업로드 해라.
---
### push / pull
그냥 git push / git pull 만 사용해도 됨. 하지만, origin main을 사용하는 이유는 어디에 올릴 것인지 명확하게 지정하기 위하여. 실무에서도 자주 사용.
---
### remote
- 원격 저장소 (Remote Repository)
- 씽크패드 <-> Github(origin) <-> 맥북
