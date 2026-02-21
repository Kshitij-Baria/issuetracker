# Entity Review Notes

This repository's JPA entities were reviewed against the provided PostgreSQL schema.

## Alignment updates applied

1. `users.username` and `users.email` are now marked unique at entity level (`@Column(unique = true)`).
2. `users.is_active` now defaults to `true` in the entity, matching schema default behavior.
3. `tasks.task_status` now defaults to `NEW` in the entity, matching schema default behavior.
4. `task_activities.user_id` is now nullable in the entity, matching schema (`user_id BIGINT REFERENCES users(user_id)`).
5. `task_activities.field_type` is now explicitly non-nullable (`nullable = false`).

## Additional suggestions (not applied yet)

1. **Fix schema typo for parent reference**: `tasks.parent_id BIGINT REFERENCES tasks(id)` should reference `tasks(task_id)`.
2. **Add explicit DB enum type mapping** in entities (using `@JdbcTypeCode(SqlTypes.NAMED_ENUM)` or migration-managed columns), especially when relying on strict PostgreSQL enum types.
3. **Bidirectional mapping completeness**: if needed by business logic, expose reverse associations from `User` for comments/watching to simplify graph traversal.
4. **Lifecycle consistency**: if soft-delete semantics are intended, consider a global filter (`@Where`) on `User` for `deleted_at IS NULL`.
5. **Validation layer**: add bean validation annotations (`@NotBlank`, `@Email`) for pre-DB validation.
