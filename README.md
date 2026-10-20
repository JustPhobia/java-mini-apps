# java-mini-apps

A handful of small console Java programs from early practice, each self-contained:

- **library/** + `LibraryApplication` — a library system: add books/members,
  borrow, return, cancel membership (menu-driven).
- **ProductManagement/** — a shop: add / update / view products (`ProductShop`
  has `main`).
- **BankingApp/Accounts/** — account types (`DefaultAccount`, `Savings`,
  `Cheque`, `FixedDeposit`, `Business`, `Loan`) with a menu driver
  (`BankingAppMain`).
- **Mug.java** — a toy drink-fill simulation.

> Built within my first ~4–5 months of learning Java (a coding course). Kept as a record of progress, not as polished production code.

## Run (examples)
```bash
find src -name '*.java' | xargs javac -d out
java -cp out LibraryApplication
java -cp out ProductManagement.ProductShop
java -cp out BankingApp.Accounts.BankingAppMain
java -cp out Mug
```

## What was added / known rough edges
- `Business` and `Loan` account types and the `BankingAppMain` driver were
  added to finish BankingApp.
- Pre-existing quirks left as-is (early-learner code): `Cheque` refuses
  withdrawals above a 0 limit; `FixedDeposit.withdraw` is unfinished and its
  constructor requires a maturity year at least one year in the future.
