enum UserStatus {
  PENDING,
  ACTIVE
}

export class User {
  id: number;
  name: string;
  email: string;
  photo: string;
  status: UserStatus;
}
