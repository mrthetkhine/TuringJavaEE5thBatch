import { Review } from './comment.model';

describe('Comment', () => {
  it('should create an instance', () => {
    expect(new Review()).toBeTruthy();
  });
});
